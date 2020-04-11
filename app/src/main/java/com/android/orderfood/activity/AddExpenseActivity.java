package com.android.orderfood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.orderfood.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddExpenseActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerCategory;
    private Spinner spinnerPaymentMode;

    private ArrayList<String> spinCategoryAdapter;
    private ArrayList<String> spinPaymentModeAdapter;

    private ArrayAdapter categoryAdapter;
    private ArrayAdapter paymentModeAdapter;

    private Button btnAddExpense;
    private EditText edtSpentDate;
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        initializations();
        setDefaults();
        setListeners();
    }

    private void initializations() {
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerPaymentMode = findViewById(R.id.spinnerPaymentMode);
        spinCategoryAdapter = new ArrayList<>();
        spinPaymentModeAdapter = new ArrayList<>();
        btnAddExpense = findViewById(R.id.btnAddExpense);
        edtSpentDate = findViewById(R.id.edtSpentDate);
    }

    private void setDefaults() {
        spinCategoryAdapter.add("Grocery");
        spinCategoryAdapter.add("Drinks");
        categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinCategoryAdapter);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        spinPaymentModeAdapter.add("Cash");
        spinPaymentModeAdapter.add("Credit Card");
        spinPaymentModeAdapter.add("Debit Card");
        paymentModeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinPaymentModeAdapter);
        paymentModeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaymentMode.setAdapter(paymentModeAdapter);
    }

    private void setListeners() {
        btnAddExpense.setOnClickListener(this);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerPaymentMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddExpense:
                Intent intent = new Intent(AddExpenseActivity.this, ViewListOrderActivity.class);
                startActivity(intent);
        }
    }

    public void showCalendar(View view) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(AddExpenseActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edtSpentDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

}
