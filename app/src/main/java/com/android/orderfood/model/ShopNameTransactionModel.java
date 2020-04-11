package com.android.orderfood.model;

public class ShopNameTransactionModel {
    private String date;
    private String bill_amount;
    private String paid;

    public ShopNameTransactionModel(String date, String bill_amount, String paid){
        this.date = date;
        this.bill_amount = bill_amount;
        this.paid = paid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBill_amount() {
        return bill_amount;
    }

    public void setBill_amount(String bill_amount) {
        this.bill_amount = bill_amount;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
