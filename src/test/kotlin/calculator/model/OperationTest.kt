package calculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class OperationTest {
    @Test
    fun `덧셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = Operation.ADD.apply(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(3))
    }

    @Test
    fun `뺄셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = Operation.SUBTRACT.apply(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(-1))
    }

    @Test
    fun `곱셈`() {
        val decimal1 = BigDecimal(3)
        val decimal2 = BigDecimal(7)

        val result = Operation.MULTIPLY.apply(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(21))
    }

    @ParameterizedTest
    @CsvSource(value = ["10:3:3", "10:3.00:3.33", "10.00:3:3.33", "100.0:20.0000:5.0000", "7:2:3"], delimiter = ':')
    fun `나눗셈`(d1: BigDecimal, d2: BigDecimal, expected: BigDecimal) {
        assertThat(Operation.DIVIDE.apply(d1, d2)).isEqualTo(expected)
    }

    @Test
    fun `0으로 나누기`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(0)

        assertThrows<ArithmeticException> { Operation.DIVIDE.apply(decimal1, decimal2) }
    }
}
