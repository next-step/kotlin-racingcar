package step2.stringCalculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun isInEnumTest(){
        assertEquals(true, Operator.isInEnum("+"))
        assertEquals(false, Operator.isInEnum("%"))
    }
    @Test
    fun fromValueTest(){
        assertEquals(Operator.PLUS, Operator.fromValue("+"))
        assertEquals(Operator.MINUS, Operator.fromValue("-"))
        assertEquals(Operator.DIVIDE, Operator.fromValue("/"))
        assertEquals(Operator.MULTIPLY, Operator.fromValue("*"))
        assertEquals(null, Operator.fromValue("123"))
    }
    @Test
    fun operateTest(){
        assertEquals(3.0, Operator.operate(Operator.PLUS, 1.0, 2.0))
        assertEquals(-1.0, Operator.operate(Operator.MINUS, 1.0, 2.0))
        assertEquals(0.5, Operator.operate(Operator.DIVIDE, 1.0, 2.0))
        assertEquals(2.0, Operator.operate(Operator.MULTIPLY, 1.0, 2.0))
    }
}
