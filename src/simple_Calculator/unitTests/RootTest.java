package simple_Calculator.unitTests;

import simple_Calculator.Calculator;

import static org.junit.Assert.*;

public class RootTest {
    @org.junit.Test
    public void rootWith_PositiveInteger() {
        assertEquals(3.16227766, Calculator.root(10), 0.0000001);
    }

    @org.junit.Test
    public void rootWith_PositiveDouble() {
        assertEquals(2.28035085, Calculator.root(5.2), 0.0000001);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void rootWith_NegativeInteger() {
        Calculator.root(-5);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void rootWith_NegativeDouble() {
        Calculator.root(-5.2);
    }

    @org.junit.Test
    public void rootWith_Zero() {
        assertEquals(0, Calculator.root(0), 0.0000001);
    }

}