package com.charlezz.mvvmsample;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.charlezz.mvvmsample.model.Person;
import com.charlezz.mvvmsample.view.MainAdapter;

import java.util.List;

public class MainCustomBinding {

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Person> items) {
        MainAdapter adapter = (MainAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }

}
