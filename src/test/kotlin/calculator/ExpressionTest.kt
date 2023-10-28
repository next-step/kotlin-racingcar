package calculator

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class ExpressionTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "    ", "\n\t"])
    fun `빈문자인 경우 예외 발생`(str: String) {
        assertThrows<IllegalArgumentException> {
            Expression(str)
        }.shouldHaveMessage("${str}은 올바른 수식이 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + 2", "2 + 3 -", "3 + * 2", "3 + --2", "2a - 3", "3 % 4"])
    fun `잘못된 수식인 경우 예외 발생`(str: String) {
        assertThrows<IllegalArgumentException> {
            Expression(str)
        }.shouldHaveMessage("${str}은 올바른 수식이 아닙니다.")
    }

    @Test
    fun `피연산자 파싱`() {
        val actual = Expression("1 + 2 / 34 * 100 - 2323 + -123").operands()

        assertThat(actual).containsExactly(
            BigDecimal.valueOf(1),
            BigDecimal.valueOf(2),
            BigDecimal.valueOf(34),
            BigDecimal.valueOf(100),
            BigDecimal.valueOf(2323),
            BigDecimal.valueOf(-123),
        )
    }

    @Test
    fun `연산자 파싱`() {
        val actual = Expression("1 + 2 / 34 * 100 - 2323 + -123").operators()

        assertThat(actual).containsExactly(
            Operator.ADD,
            Operator.DIVIDE,
            Operator.MULTIPLY,
            Operator.SUBTRACT,
            Operator.ADD
        )
    }
}
