package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3", "2,3,5", "3,4,7"])
    fun `덧셈 연산이 잘 계산된다`(x: Int, y: Int, result: Int) {
        assertEquals(result, Operator.PLUS.operation(x, y))
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,-1", "2,3,-1", "3,4,-1"])
    fun `뺄셈 연산이 잘 계산된다`(x: Int, y: Int, result: Int) {
        assertEquals(result, Operator.MINUS.operation(x, y))
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,2", "2,3,6", "3,4,12"])
    fun `곱셈 연산이 잘 계산된다`(x: Int, y: Int, result: Int) {
        assertEquals(result, Operator.TIMES.operation(x, y))
    }

    @ParameterizedTest
    @CsvSource(value = ["2,1,2", "2,2,1", "3,4,0"])
    fun `나눗셈 연산이 잘 계산된다`(x: Int, y: Int, result: Int) {
        assertEquals(result, Operator.DIVISION.operation(x, y))
    }

    @ParameterizedTest
    @CsvSource(value = ["+,PLUS", "-,MINUS", "*,TIMES", "/,DIVISION"])
    fun `연산자가 잘 매핑된다`(symbol: String, operator: Operator) {
        assertEquals(operator, Operator.from(symbol))
    }
}
