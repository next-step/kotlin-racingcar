package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["4 + 2 - 3, 3", "4 - 3 * -2 / 2 + 10, 9"])
    fun `수식 계산`(str: String, expect: BigDecimal) {
        val actual = Calculator.exec(Expression(str))

        assertThat(actual).isEqualTo(expect)
    }
}
