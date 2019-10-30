package com.charlezz.mvvmsample.view;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.charlezz.mvvmsample.R;
import com.charlezz.mvvmsample.databinding.ActivityMainBinding;
import com.charlezz.mvvmsample.model.Database;
import com.charlezz.mvvmsample.model.Person;
import com.charlezz.mvvmsample.viewmodel.MainViewModel;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainViewHolder.HolderClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    MainViewModel viewModel;
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MainAdapter(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);

        viewModel = new MainViewModel(Database.getInstance());
        binding.setViewModel(viewModel);

        viewModel.load();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        viewModel.addPerson(new Person(System.currentTimeMillis(), String.format("New Charles %d", new Random().nextInt(1000))));
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onDeleteClick(Person person) {
        viewModel.removePerson(person);
    }
}
