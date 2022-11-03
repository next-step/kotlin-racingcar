package calculator

import calculator.StringCalculator.Companion.add
import calculator.StringCalculator.Companion.divide
import calculator.StringCalculator.Companion.multiply
import calculator.StringCalculator.Companion.subtract
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = add(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(3))
    }

    @Test
    fun `뺄셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = subtract(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(-1))
    }

    @Test
    fun `곱셈`() {
        val decimal1 = BigDecimal(3)
        val decimal2 = BigDecimal(7)

        val result = multiply(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(21))
    }

    @Test
    fun `나눗셈`() {
        val decimal1 = BigDecimal(10)
        val decimal2 = BigDecimal(3)

        val result = divide(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(3))
    }

    @Test
    fun `0으로 나누기`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(0)

        assertThatThrownBy { divide(decimal1, decimal2) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값 검증`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `사칙연산 기호 검증`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `문자열 사칙연산`() {
        TODO("Not yet implemented")
    }
}
