package com.android.orderfood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.orderfood.R;
import com.android.orderfood.adapter.ShopNameTransactionAdapter;
import com.android.orderfood.model.ShopNameTransactionModel;

import java.util.ArrayList;
import java.util.List;

public class ShopNameTransactionActivity extends AppCompatActivity {

    private RecyclerView recyclerView_shop_name;
    private List<ShopNameTransactionModel> shopNameTransactionModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_name_transaction);

        initializations();
        setDefaults();
        setListeners();
    }

    private void initializations() {
        recyclerView_shop_name = findViewById(R.id.recylerview_shop_name);
        shopNameTransactionModels = new ArrayList<>();
    }

    private void setDefaults() {
        recyclerView_shop_name.setHasFixedSize(true);
        recyclerView_shop_name.setLayoutManager(new LinearLayoutManager(this));

        shopNameTransactionModels.add(new ShopNameTransactionModel("2020-03-04", "1000", "1000"));
        shopNameTransactionModels.add(new ShopNameTransactionModel("2020-03-03", "3000", "1000"));
        shopNameTransactionModels.add(new ShopNameTransactionModel("2020-03-02", "4000", "1000"));

        ShopNameTransactionAdapter adapter = new ShopNameTransactionAdapter(this, shopNameTransactionModels);

        recyclerView_shop_name.setAdapter(adapter);
    }

    private void setListeners() {
    }
}
