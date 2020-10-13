package com.charlezz.android;

import java.util.ArrayList;

import org.junit.Test;

import dagger.hilt.android.testing.HiltAndroidTest;

/**
 * @author Charlezz
 */
@HiltAndroidTest
public class ExampleUnitTestByJava {


    ArrayList<Integer> list = new ArrayList<>();
    @Test
    public void concurrencyTest() throws InterruptedException {

        new Thread(() -> {
            while (true){
                arrange();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true){
                arrange();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10000);
    }

    public void arrange(){

        list.clear();
        list.add(1);
        list.remove(list.size()-1);

    }


}
