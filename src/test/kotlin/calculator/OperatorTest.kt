package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class OperatorTest {

    @Test
    fun `PlusOperator 테스트`() {
        // Given
        val operator = ArithmeticOperator.PLUS

        // When
        val expected = 2 + 3
        val actual = operator.operate(2, 3)

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `SubtractOperator 테스트`() {
        // Given
        val operator = ArithmeticOperator.SUBTRACT

        // When
        val expected = 5 - 5
        val actual = operator.operate(5, 5)

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `MultiplyOperator 테스트`() {
        // Given
        val operator = ArithmeticOperator.MULTIPLY

        // When
        val expected = 4 * 5
        val actual = operator.operate(4, 5)

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `DivideOperator 테스트`() {
        // Given
        val operator = ArithmeticOperator.DIVIDE

        // When
        val expected = 10 / 2
        val actual = operator.operate(10, 2)

        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `DivideOperator는 0으로 나눌 수 없음`() {
        // Given
        val operator = ArithmeticOperator.DIVIDE

        // When
        val executable = Executable { operator.operate(10, 0) }

        // Then
        assertThrows(ArithmeticException::class.java, executable)
    }
}
