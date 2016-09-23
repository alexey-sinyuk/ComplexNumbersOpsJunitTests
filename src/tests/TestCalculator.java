package tests;

import org.junit.Assert;
import org.junit.Test;

import main.Calculator;
import main.Complex;

public class TestCalculator {

    @Test
    public void TestEquals()
    {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(1, 2);
        Assert.assertEquals(true, Calculator.IsEqual(a, b));
    }

    @Test
    public void TestAdd()
    {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(2, 6);
        Complex expected = new Complex(3, 8);
        Assert.assertEquals(true, Calculator.IsEqual(expected, Calculator.Add(a, b)));
    }

    @Test
    public void TestSub()
    {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(2, 6);
        Complex expected = new Complex(-1, -4);
        Assert.assertEquals(true, Calculator.IsEqual(expected, Calculator.Sub(a, b)));
    }

    @Test
    public void TestMul()
    {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(2, 6);
        Complex expected = new Complex(-10, 10);
        Assert.assertEquals(true, Calculator.IsEqual(expected, Calculator.Mul(a, b)));
    }

    @Test
    public void TestDiv()
    {
        Complex a = new Complex(1, 0);
        Complex b = new Complex(1, 1);
        Complex expected = new Complex(0.5, -0.5);
        Assert.assertEquals(true, Calculator.IsEqual(expected, Calculator.Div(a, b)));
    }

}
