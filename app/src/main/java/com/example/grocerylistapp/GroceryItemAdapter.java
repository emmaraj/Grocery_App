package com.example.grocerylistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GroceryItemAdapter extends RecyclerView.Adapter<GroceryItemAdapter.MyViewHolder> {

    private static int pos;
    private ArrayList<GroceryItem> items;

    public GroceryItemAdapter(ArrayList<GroceryItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GroceryItem currentItem = items.get(position);
        pos = position;
        holder.priceTextView.setText(String.valueOf(currentItem.getItemPrice()));
        holder.nameTextView.setText(String.valueOf(currentItem.getItemName()));
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (items != null){
            size = items.size();
        }
        return size;
    }

    public static int getPos() {
        return pos;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView priceTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.grocery_name);
            priceTextView = itemView.findViewById(R.id.grocery_price);
        }
    }

}
