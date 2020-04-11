package com.android.orderfood.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.orderfood.R;
import com.android.orderfood.adapter.ViewListOrderAdapter;
import com.android.orderfood.model.ShopNameTransactionModel;
import com.android.orderfood.model.ViewListOrderModel;

import java.util.ArrayList;
import java.util.List;

public class ViewListOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView_view_list;
    private List<ViewListOrderModel> viewListOrderModels;

    private Button btnConfirmOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_order);

        initializations();
        setDefaults();
        setListeners();
    }

    private void initializations() {
        recyclerView_view_list = findViewById(R.id.recylerview_view_list);
        viewListOrderModels = new ArrayList<>();
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
    }

    private void setDefaults() {
        recyclerView_view_list.setHasFixedSize(true);
        recyclerView_view_list.setLayoutManager(new LinearLayoutManager(this));

        recyclerView_view_list.addItemDecoration(new SimpleDividerItemDecoration(this));

        viewListOrderModels.add(new ViewListOrderModel("1", "Sunflower Oil", "500 ML", "2"));
        viewListOrderModels.add(new ViewListOrderModel("2", "Dal", "1 KG", "1"));
        viewListOrderModels.add(new ViewListOrderModel("3", "Sugar", "5 KG", "1"));

        ViewListOrderAdapter adapter = new ViewListOrderAdapter(this, viewListOrderModels);

        recyclerView_view_list.setAdapter(adapter);
    }

    private void setListeners() {
        btnConfirmOrder.setOnClickListener(this);
    }

    private void showCustomDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(this).inflate(R.layout.confirm_order_otp, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button btnResendOtp = dialogView.findViewById(R.id.btnResendOTP);
        btnResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        EditText edtFirst = dialogView.findViewById(R.id.edtFirst);
        final EditText edtSecond = dialogView.findViewById(R.id.edtSecond);
        final EditText edtThird = dialogView.findViewById(R.id.edtThird);
        final EditText edtFourth = dialogView.findViewById(R.id.edtFourth);

        edtFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    edtSecond.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    edtThird.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    edtFourth.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirmOrder:
                showCustomDialog();
                break;
            default:
        }
    }

    public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.recycler_horizontal_divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
