package com.android.orderfood.model;

public class ViewListOrderModel {
    private String id;
    private String itemName;
    private String quantity;
    private String numberofitems;

    public ViewListOrderModel(String id, String itemName, String quantity, String numberofitems) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.numberofitems = numberofitems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNumberofitems() {
        return numberofitems;
    }

    public void setNumberofitems(String numberofitems) {
        this.numberofitems = numberofitems;
    }
}
