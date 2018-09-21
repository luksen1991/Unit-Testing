package com.example.unittesting.unittesting.spike;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestUnitTest {

    @Test
    public void learning(){
        List<Integer> numbers= Arrays.asList(12,15,24);
        assertThat(numbers,hasSize(3));
        assertThat(numbers,hasItems(12,15));
        assertThat(numbers,everyItem(greaterThan(11)));
        assertThat(numbers,hasItems(12,15));
        assertThat(numbers,everyItem(lessThan(100)));

        assertThat("",isEmptyString());
        assertThat("ABCDE",containsString("BC"));
        assertThat("ABCDE",startsWith("ABC"));
        assertThat("ABCDE",endsWith("CDE"));

    }
}
