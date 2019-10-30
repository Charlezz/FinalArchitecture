package com.charlezz.mvcsample.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.charlezz.mvcsample.R;
import com.charlezz.mvcsample.model.Database;
import com.charlezz.mvcsample.model.Person;
import com.charlezz.mvcsample.view.MainViewHolder;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainViewHolder.HolderClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;
    Database database = Database.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setItems(database.getPersonList());
        database.setOnDatabaseListener(new Database.DatabaseListener(){
            @Override
            public void onChanged() {
                adapter.setItems(database.getPersonList());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        database.add(new Person(System.currentTimeMillis(), String.format("New Charles %d", new Random().nextInt(1000))));
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onDeleteClick(Person person) {
        database.remove(person);
    }
}
