package com.charlezz.mvvmsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlezz.mvvmsample.R;
import com.charlezz.mvvmsample.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<Person> items = new ArrayList<>();
    private MainViewHolder.HolderClickListener holderClickListener;

    public MainAdapter(MainViewHolder.HolderClickListener holderClickListener){
        this.holderClickListener = holderClickListener;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_main, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
        mainViewHolder.setPerson(items.get(position));
        mainViewHolder.setOnHolderClickListener(holderClickListener);
    }

    public void setItems(List<Person> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Person> getItems() {
        return items;
    }
}
