package com.charlezz.mvvmsample;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

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
