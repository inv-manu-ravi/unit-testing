package com.example.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyServiceTest {
    Calculator calc = new Calculator();
    @Test
    public void testAdd() {
       
        int result = calc.add(2, 3);
        assertEquals(5, result);
       
    }
    @Test
    public void testProduct(){
        int product=calc.product(2,4);
        assertEquals(8, product);
    }
    
}
