package step2

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource

internal class OperatorTest {

    @ParameterizedTest
    @EnumSource(Operator::class)
    fun `symbol representation test`(operator: Operator) {
        assertTrue("+-*/".contains(operator.symbol))
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 3.0, 5.0",
        "8.0, 1.0, 9.0",
        "3.0, 4.0, 7.0",
        "8.0, 4.0, 12.0"
    )
    fun `Enum PLUS test`(operand1: Double, operand2: Double, result: Double) {
        assertEquals(result, Operator.PLUS.apply(operand1, operand2))
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 3.0, -1.0",
        "8.0, 1.0, 7.0",
        "3.0, 4.0, -1.0",
        "8.0, 4.0, 4.0"
    )
    fun `Enum MINUS test`(operand1: Double, operand2: Double, result: Double) {
        assertEquals(result, Operator.MINUS.apply(operand1, operand2))
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 3.0, 6.0",
        "8.0, 1.0, 8.0",
        "3.0, 4.0, 12.0",
        "8.0, 4.0, 32.0"
    )
    fun `Enum TIMES test`(operand1: Double, operand2: Double, result: Double) {
        assertEquals(result, Operator.TIMES.apply(operand1, operand2))
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 4.0, 0.5",
        "8.0, 1.0, 8.0",
        "3.0, 4.0, 0.75",
        "8.0, 4.0, 2.0"
    )
    fun `Enum DEVIDE test`(operand1: Double, operand2: Double, result: Double) {
        assertEquals(result, Operator.DEVIDE.apply(operand1, operand2))
    }

    @Test
    fun `Enum DEVIDE by zero test`() {
        assertThatThrownBy { Operator.DEVIDE.apply(10.0, 0.0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Divide by zero")
    }
}
