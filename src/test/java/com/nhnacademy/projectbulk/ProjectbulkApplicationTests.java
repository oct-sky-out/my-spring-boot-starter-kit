package com.nhnacademy.projectbulk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectbulkApplicationTests {

    @Test
    void contextLoads() {
        assertThat(1+1).isEqualTo(2);
    }

}
