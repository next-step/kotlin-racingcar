package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class OperatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3", "1, 20, 21", "3, -2, 1"])
    fun `덧셈`(left: BigDecimal, right: BigDecimal, expect: BigDecimal) {
        val actual = Operator.ADD.apply(left, right)

        Assertions.assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["3, 2, 1", "20, 40, -20"])
    fun `뺄셈`(left: BigDecimal, right: BigDecimal, expect: BigDecimal) {
        val actual = Operator.SUBTRACT.apply(left, right)

        Assertions.assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2, 4, 8", "5, 4, 20", "-2, 23, -46"])
    fun `곱셈`(left: BigDecimal, right: BigDecimal, expect: BigDecimal) {
        val actual = Operator.MULTIPLY.apply(left, right)

        Assertions.assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["4, 2, 2", "3, 4, 0.75", "1, -8, -0.125"])
    fun `나눗셈`(left: BigDecimal, right: BigDecimal, expect: BigDecimal) {
        val actual = Operator.DIVIDE.apply(left, right)

        Assertions.assertThat(actual).isEqualTo(expect)
    }
}
