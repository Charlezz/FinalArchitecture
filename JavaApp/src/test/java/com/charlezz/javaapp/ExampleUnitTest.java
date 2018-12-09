package com.charlezz.javaapp;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void check(){
        String text = "http://jsonplaceholder.typicode.com/posts?_page=3";

        Pattern PAGE_PATTERN = Pattern.compile("\\b_page=(\\d+)");

        Matcher matcher = PAGE_PATTERN.matcher(text);
        if (!matcher.find() || matcher.groupCount() != 1) {
            System.out.print("error");
        } else {
            try {
                System.out.println("result="+Integer.parseInt(matcher.group(1)));
            } catch (NumberFormatException e) {
                System.out.print("NumberFormatException");
                e.printStackTrace();
            }
        }
    }
}