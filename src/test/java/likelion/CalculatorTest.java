package likelion;

import edu.likelion.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    /*
"1 + 1"
"1 + 2"
"1 - 2"
"1 * 2"
"4 / 2"
"1 + 2 + 3"
"1 + 2 * 3"
"(1 + 2) * 3"
*/
    @Test
    void add1() {
        int rs = Calculator.calc("1 + 1");
        assertEquals(2, rs);
    }
    @Test
    void add2() {
        int rs = Calculator.calc("1 + 2");
        assertEquals(3, rs);
    }
    @Test
    void add3() {
        int rs = Calculator.calc("1 - 2");
        assertEquals(-1, rs);
    }
    @Test
    void add4() {
        int rs = Calculator.calc("1 * 2");
        assertEquals(2, rs);
    }
    @Test
    void add5() {
        int rs = Calculator.calc("4 / 2");
        assertEquals(2, rs);
    }
    @Test
    void add6() {
        int rs = Calculator.calc("1 + 2 + 3");
        assertEquals(6, rs);
    }

}