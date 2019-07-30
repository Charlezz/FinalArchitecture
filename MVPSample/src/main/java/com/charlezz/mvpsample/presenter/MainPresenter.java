package com.charlezz.mvpsample.presenter;

import com.charlezz.mvpsample.MainContract;
import com.charlezz.mvpsample.model.Database;
import com.charlezz.mvpsample.model.Person;

public class MainPresenter implements MainContract.Presenter{

    private Database database;
    private MainContract.View view;

    public MainPresenter(Database database, MainContract.View view){
        this.database = database;
        this.view = view;
        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                MainPresenter.this.view.notifyDataChanged();
            }
        });
    }


    @Override
    public void load() {
        view.showPersonList(database.getPersonList());
    }

    @Override
    public void addPerson(Person person) {
        database.add(person);
    }

    @Override
    public void removePerson(Person person) {
        database.remove(person);
    }
}
