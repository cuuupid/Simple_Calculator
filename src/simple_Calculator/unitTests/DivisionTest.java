package simple_Calculator.unitTests;

import static org.junit.Assert.*;

import simple_Calculator.Calculator;


public class DivisionTest {

    @org.junit.Test
    public void divisionWith_PositiveIntegers(){
        assertEquals(3, Calculator.division(9, 3), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_PositiveDoubles(){
        assertEquals(2.7142857142, Calculator.division(9.5, 3.5), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_PositiveAndNegativeIntegers(){
        assertEquals(-2, Calculator.division(-4, 2), 0.0000001);
        assertEquals(-2, Calculator.division(4, -2), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_PositiveAndNegativeDoubles(){
        assertEquals(-2.04761904, Calculator.division(-4.3, 2.1), 0.0000001);
        assertEquals(-2.04761904, Calculator.division(4.3, -2.1), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_NegativeIntegers(){
        assertEquals(2, Calculator.division(-4, -2), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_NegativeDoubles(){
        assertEquals(2.04761904, Calculator.division(-4.3, -2.1), 0.0000001);
    }

    @org.junit.Test
    public void divisionWith_ZeroOnTop(){
        assertEquals(0, Calculator.division(0, 4), 0.0000001);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void divisionWith_ZeroOnBottom(){
        Calculator.division(4, 0);
    }


}