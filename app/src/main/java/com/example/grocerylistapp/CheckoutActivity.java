package com.example.grocerylistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        RecyclerView recyclerView = findViewById(R.id.itemsRecyclerView);
        recyclerView.setHasFixedSize(true);
//
        ArrayList<GroceryItem> myItems = (ArrayList<GroceryItem>) getIntent().getSerializableExtra("Bundle");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<GroceryItemAdapter.MyViewHolder> adapter = new GroceryItemAdapter(myItems);
        recyclerView.setAdapter(adapter);

        double totalAmount = getItemTotalAmount(myItems);
        double shippingCost = myItems.size() * 1200;
        double orderTotalAmount = totalAmount + shippingCost;

        TextView totalAmountTextView = findViewById(R.id.totalItemsAmountText);
        totalAmountTextView.setText(String.valueOf(totalAmount));

        TextView shippingAmountTextView = findViewById(R.id.shippingAmountText);
        shippingAmountTextView.setText(String.valueOf(shippingCost));

        TextView ordersTotal = findViewById(R.id.orderTotalAmountText);
        ordersTotal.setText(String.valueOf(orderTotalAmount));
    }

    private double getItemTotalAmount(ArrayList<GroceryItem> groceryItems){
        double totalAmount = 0.0;

        for (int i = 0; i < groceryItems.size(); i++){
            totalAmount += groceryItems.get(i).getItemPrice();
        }

        return totalAmount;
    }
}
