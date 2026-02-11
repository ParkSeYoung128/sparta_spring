package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    @Autowired
    Food food;

    @Autowired
    @Qualifier("pizza")
     Food food1;

    @Test
    @DisplayName("우선순위 Priamary Bean 선택")
    void test1(){
        food.eat();
    }

}
