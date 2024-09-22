package com.example.tugas04_pam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;
    private EditText etName;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);

        // Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data list
        itemList = new ArrayList<>();
        itemList.add(new Item("1", "Matcha"));
        itemList.add(new Item("2", "Caramel"));
        itemList.add(new Item("3", "Hazelnut"));
        itemList.add(new Item("4", "Chocolate"));
        itemList.add(new Item("5", "Orange"));
        itemList.add(new Item("6", "Strawberry"));

        // Set Adapter
        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Save button listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if (!name.isEmpty()) {
                    // Add new item to the list
                    itemList.add(new Item(String.valueOf(itemList.size() + 1), name));
                    adapter.notifyDataSetChanged();  // Refresh RecyclerView
                    etName.setText("");  // Clear input field
                }
            }
        });
    }
}
