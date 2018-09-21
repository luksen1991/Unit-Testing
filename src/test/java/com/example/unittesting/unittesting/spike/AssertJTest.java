package com.example.unittesting.unittesting.spike;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;


public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 24);
        assertThat(numbers).containsOnlyOnce(12).contains(12,15).doesNotContain(30).isSorted();
        assertThat(numbers).allMatch(x -> x > 11).noneMatch(x -> x < 0);

        assertThat("ABCDE")
                .contains("BC")
                .endsWith("DE")
                .startsWith("ABC")
                .isNotEmpty();

        assertThat("").isEmpty();
        
    }
}
