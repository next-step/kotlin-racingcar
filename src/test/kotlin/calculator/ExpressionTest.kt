package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

class ExpressionTest {
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "1 + 2 * 3 / 3=3",
            "2 * 3 / 2 + 1=4",
            "2 + 3 * 4 / 2=10"
        ],
        delimiter = '='
    )
    fun `문자열로 이루어진 식을 받아 계산한다`(str: String, expected: BigDecimal) {
        val expression = Expression.from(str)
        Assertions.assertThat(expression.getResult()).isEqualTo(expected)
    }

    @Test
    fun `빈 문자열은 예외가 발생한다`() {
        Assertions.assertThatThrownBy { Expression.from("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자가 아닌 경우 예외가 발생한다`() {
        Assertions.assertThatThrownBy { Expression.from("1 + @") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
