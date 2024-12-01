package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NumberCalculatorTest {
    @Test
    fun `덧셈을 수행한다`() {
        val result = NumberCalculator.sum(1, 2)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `뺄셈을 수행한다`() {
        val result = NumberCalculator.subtract(1, 2)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `곱셈을 수행한다`() {
        val result = NumberCalculator.multiply(1, 2)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `나눗셈을 수행한다`() {
        val result = NumberCalculator.divide(2, 2)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `나눗셈 수행 시 right 값이 0일 경우 예외를 발생시킨다`() {
        assertThatThrownBy { NumberCalculator.divide(2, 0) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        "2, PLUS, 2, 4",
        "2, MINUS, 2, 0",
        "2, MULTIPLY, 2, 4",
        "2, DIVIDE, 2, 1",
    )
    fun `입력된 연산자에 해당하는 연산을 수행한다`(
        leftNumber: Int,
        operator: Operator,
        rightNumber: Int,
        expected: Int,
    ) {
        val actual = NumberCalculator.calculate(leftNumber, operator, rightNumber)

        assertThat(actual).isEqualTo(expected)
    }
}
