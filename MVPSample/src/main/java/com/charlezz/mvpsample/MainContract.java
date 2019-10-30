package com.charlezz.mvpsample;

import com.charlezz.mvpsample.model.Person;

import java.util.List;

public class MainContract {
    public interface View{
        void showPersonList(List<Person> personList);
        void notifyDataChanged();
    }
    public interface Presenter{
        void load();
        void addPerson(Person person);
        void removePerson(Person person);
    }
}
