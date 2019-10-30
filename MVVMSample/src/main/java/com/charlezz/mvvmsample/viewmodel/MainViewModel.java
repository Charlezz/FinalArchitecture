package com.charlezz.mvvmsample.viewmodel;

import androidx.databinding.BaseObservable;

import com.charlezz.mvvmsample.model.Database;
import com.charlezz.mvvmsample.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {

    private Database database;

    private List<Person> items = new ArrayList<>();

    public MainViewModel(Database database){
        this.database = database;
        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                load();
            }
        });
    }

    public void load(){
        items.clear();
        items.addAll(database.getPersonList());
        notifyChange();
    }

    public void addPerson(Person person){
        database.add(person);
    }

    public void removePerson(Person person){
        database.remove(person);
    }

    public List<Person> getItems(){
        return items;
    }

}
