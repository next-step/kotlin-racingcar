package calculator.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class CalculationTest {
    @Test
    fun `덧셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = Calculation.ADD.calculate(decimal1, decimal2)

        Assertions.assertThat(result).isEqualTo(BigDecimal(3))
    }

    @Test
    fun `뺄셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = Calculation.SUBTRACT.calculate(decimal1, decimal2)

        Assertions.assertThat(result).isEqualTo(BigDecimal(-1))
    }

    @Test
    fun `곱셈`() {
        val decimal1 = BigDecimal(3)
        val decimal2 = BigDecimal(7)

        val result = Calculation.MULTIPLY.calculate(decimal1, decimal2)

        Assertions.assertThat(result).isEqualTo(BigDecimal(21))
    }

    @ParameterizedTest
    @CsvSource(value = ["10:3:3", "10:3.00:3.33", "10.00:3:3.33", "100.0:20.0000:5.0000"], delimiter = ':')
    fun `나눗셈`(d1: BigDecimal, d2: BigDecimal, expected: BigDecimal) {
        Assertions.assertThat(Calculation.DIVIDE.calculate(d1, d2)).isEqualTo(expected)
    }

    @Test
    fun `0으로 나누기`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(0)

        Assertions.assertThatThrownBy { Calculation.DIVIDE.calculate(decimal1, decimal2) }
            .isInstanceOf(ArithmeticException::class.java)
    }
}
