package com.example.unittesting.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService = "["+"{\"id\":1, \"name\":Czapka, \"quantity\":5}" +
                "{\"id\":2, \"name\":Olowek, \"quantity\":15}" +
                "{\"id\":3, \"name\":Kurtka, \"quantity\":10}" +
                "]";

        DocumentContext context= JsonPath.parse(responseFromService);
        int length = context.read("$.length()");

        assertThat(length).isEqualTo(3);

        System.out.println(context.read("$..id").toString());
        System.out.println(context.read("$..quantity").toString());
        System.out.println(context.read("$..[0:2]").toString());
        System.out.println(context.read("$.[?(@.quantity>5)]").toString());
    }
}
