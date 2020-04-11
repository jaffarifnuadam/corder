package com.android.orderfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.orderfood.R;
import com.android.orderfood.model.ViewListOrderModel;

import java.util.List;

public class ViewListOrderAdapter extends RecyclerView.Adapter<ViewListOrderAdapter.ViewListOrderHolder> {

    private Context context;
    private List<ViewListOrderModel> viewListOrderModels;

    public ViewListOrderAdapter(Context context, List<ViewListOrderModel> viewListOrderModels) {
        this.context = context;
        this.viewListOrderModels = viewListOrderModels;
    }

    @NonNull
    @Override
    public ViewListOrderAdapter.ViewListOrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_list_order, null);
        return new ViewListOrderAdapter.ViewListOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewListOrderAdapter.ViewListOrderHolder holder, int position) {
        ViewListOrderModel viewListOrderModel = viewListOrderModels.get(position);
        holder.txtId.setText(viewListOrderModel.getId());
        holder.txtItemName.setText(viewListOrderModel.getItemName());
        holder.txtQuantity.setText(viewListOrderModel.getQuantity());
        holder.txtNumberOfItems.setText(viewListOrderModel.getNumberofitems());
    }

    @Override
    public int getItemCount() {
        return viewListOrderModels.size();
    }

    class ViewListOrderHolder extends RecyclerView.ViewHolder {

        private TextView txtId;
        private TextView txtItemName;
        private TextView txtQuantity;
        private TextView txtNumberOfItems;

        public ViewListOrderHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtId);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            txtNumberOfItems = itemView.findViewById(R.id.txtNumberOfItems);
        }
    }
}
