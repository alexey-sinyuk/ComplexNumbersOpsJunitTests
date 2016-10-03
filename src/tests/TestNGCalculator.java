package tests;

import main.Calculator;
import main.Complex;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGCalculator {

    @Test(groups = {"positive"})
    public void equalsTest (){
        Assert.assertTrue(Calculator.IsEqual(new Complex(1, 1), new Complex(1, 1)));
    }

    @DataProvider(name = "add_test", parallel = true)
    public Object[][] add_test (){
        return new Object[][]{
                new Complex[] {new Complex(1, 1), new Complex (2, 2), new Complex (3, 3)},
                new Complex[] {new Complex(1, 1), new Complex (-2, 2), new Complex (-1, 3)},
                new Complex[] {new Complex(-1, -1), new Complex (-2, 2), new Complex (-3, 1)}
        };
    }

    @Test(dataProvider = "add_test", groups = {"positive"}, dependsOnMethods = {"equalsTest"})
    public void addTest (Complex a, Complex b, Complex expected) {
        Assert.assertTrue(Calculator.IsEqual(expected, Calculator.Add(a, b)));
    }

    @DataProvider(name = "sub_test", parallel = true)
    public Object[][] sub_test (){
        return new Object[][]{
                new Complex[] {new Complex(1, 1), new Complex (2, 2), new Complex (-1, -1)},
                new Complex[] {new Complex(1, 1), new Complex (-2, 2), new Complex (3, -1)},
                new Complex[] {new Complex(-1, -1), new Complex (-2, 2), new Complex (1, -3)}
        };
    }

    @Test(dataProvider = "sub_test", groups = {"positive"}, dependsOnMethods = {"equalsTest"})
    public void subTest (Complex a, Complex b, Complex expected) {
        Assert.assertTrue(Calculator.IsEqual(expected, Calculator.Sub(a, b)));
    }

    @Test(groups = {"positive"}, dependsOnMethods = {"equalsTest"})
    public void mulTest()
    {
        Assert.assertTrue(Calculator.IsEqual(new Complex(-10, 10), Calculator.Mul(new Complex(1, 2), new Complex(2, 6))));
    }

    @Test(groups = {"positive"}, dependsOnMethods = {"equalsTest"})
    public void divTest()
    {
        Assert.assertTrue(Calculator.IsEqual(new Complex(0.5, -0.5), Calculator.Div(new Complex(1, 0), new Complex(1, 1))));
    }

    @Test(groups = {"negative"})
    public void negativeEqualsTest (){
        Assert.assertFalse(Calculator.IsEqual(new Complex(1,1), new Complex(2, 2 )));
    }

}
