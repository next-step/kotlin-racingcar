package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {

    @ParameterizedTest
    @ValueSource(strings = ["123 + Thirteen", "123 + 3849 ^ 13"])
    fun `non-arithmetic operator or non-digit check test`(inputStr: String) {
        assertThatThrownBy{ Expression(inputStr) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("inputStr contains non-digit or non-arithmetic characters")
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, 2.0 3.0 4.0 2.0",
        "21 * 63 / 3 / 7 - 10, 21.0 63.0 3.0 7.0 10.0",
        "223 - 63 * 4 / 2, 223.0 63.0 4.0 2.0",
        "2123 - 10 + 50 / 4, 2123.0 10.0 50.0 4.0"
    )
    fun `getOperands test`(inputStr: String, expected: String) {
        assertThat(expected).isEqualTo(
            Expression(inputStr).operands
                .joinToString(" ")
        )
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2, + + * /",
        "21 * 63 / 3 / 7 - 10, + * / / -",
        "223 - 63 * 4 / 2, + - * /",
        "2123 - 10 + 50 / 4, + - + /"
    )
    fun `getOperators test`(inputStr: String, expected: String) {
        assertThat(
            Expression(inputStr).operators
                .joinToString(" ") { it.symbol }
        ).isEqualTo(expected)
    }
}
