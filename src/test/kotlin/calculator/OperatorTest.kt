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
}
