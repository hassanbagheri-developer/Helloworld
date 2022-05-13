import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCalculator {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.sum(2,5),7); }
    @Test
    public void testMinus() {
        Calculator calculator = new Calculator();
        assertEquals( calculator.minus(2, 2),0); }
    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals( calculator.divide(6, 3),2); }
    @Test
    public void multiply() {
        Calculator calculator = new Calculator();
        assertEquals( calculator.multiply(6, 4),24); }
    @Test(expected = ArithmeticException.class)
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        Calculator calculator = new Calculator();
        calculator.divide(6, 0); }}