package com.charlezz.mvpsample.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.charlezz.mvpsample.MainContract;
import com.charlezz.mvpsample.R;
import com.charlezz.mvpsample.model.Database;
import com.charlezz.mvpsample.model.Person;
import com.charlezz.mvpsample.presenter.MainPresenter;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainContract.View, MainViewHolder.HolderClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;
    MainContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MainAdapter(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        presenter = new MainPresenter(Database.getInstance(), this);
        presenter.load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.addPerson(new Person(System.currentTimeMillis(), String.format("New Charles %d", new Random().nextInt(1000))));
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void showPersonList(List<Person> personList) {
        adapter.setItems(personList);
    }

    @Override
    public void notifyDataChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteClick(Person person) {
        presenter.removePerson(person);
    }
}
