package com.android.orderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.orderfood.R;
import com.android.orderfood.model.ShopNameTransactionModel;

import java.util.List;

public class ShopNameTransactionAdapter extends RecyclerView.Adapter<ShopNameTransactionAdapter.ShopNameViewHolder> {

    private Context context;
    private List<ShopNameTransactionModel> shopNameTransactionModels;

    public ShopNameTransactionAdapter(Context context, List<ShopNameTransactionModel> shopNameTransactionModels) {
        this.context = context;
        this.shopNameTransactionModels = shopNameTransactionModels;
    }

    @NonNull
    @Override
    public ShopNameTransactionAdapter.ShopNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shop_name_transaction_list, null);
        return new ShopNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopNameTransactionAdapter.ShopNameViewHolder holder, int position) {
        ShopNameTransactionModel shopNameTransactionModel = shopNameTransactionModels.get(position);
        holder.txtDate.setText(shopNameTransactionModel.getDate());
        holder.txtBillAmount.setText(shopNameTransactionModel.getBill_amount());
        holder.txtPaid.setText(shopNameTransactionModel.getPaid());
        holder.txtViewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return shopNameTransactionModels.size();
    }

    class ShopNameViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDate;
        private TextView txtBillAmount;
        private TextView txtPaid;
        private TextView txtViewBill;

        public ShopNameViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDate = itemView.findViewById(R.id.txtDate);
            txtViewBill = itemView.findViewById(R.id.txtViewBill);
            txtBillAmount = itemView.findViewById(R.id.txtBillAmount);
            txtPaid = itemView.findViewById(R.id.txtPaid);
        }
    }

}
