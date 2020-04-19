package com.example.grocerylistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<GroceryItem> myItems = new ArrayList<GroceryItem>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.itemsRecyclerView);
        recyclerView.setHasFixedSize(true);
//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<GroceryItemAdapter.MyViewHolder> adapter = new GroceryItemAdapter(myItems);
        recyclerView.setAdapter(adapter);
    }

    public void onClickAddToList(View view) {
        EditText nameEditText = findViewById(R.id.grocery_name_edit_text);
        EditText priceEditText = findViewById(R.id.grocery_price_edit_text);

        String name = nameEditText.getText().toString();
        String price = (priceEditText.getText().toString());

        if (name.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Please Input a value", Toast.LENGTH_SHORT).show();
        } else {
            myItems.add(GroceryItemAdapter.getPos(), new GroceryItem(name, Double.parseDouble(price)));
            //Toast.makeText(this, "Item Added:" + name, Toast.LENGTH_SHORT).show();
            adapter = new GroceryItemAdapter(myItems);
            recyclerView.setAdapter(adapter);
        }
    }

    public void onClickCheckout(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("Bundle", myItems);
//        Log.v("MyApp","Size: " + myItems.get(0).getItemName());
        startActivity(intent);
    }
}
