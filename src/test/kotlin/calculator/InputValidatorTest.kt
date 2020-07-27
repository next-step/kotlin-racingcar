package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputValidatorTest {

    @Test
    fun isValidExpression() {
        assertThat(InputValidator.isValidExpression(ExpressionParser.parse("3 + 4 / 2 + 5"))).isTrue()
        assertThat(InputValidator.isValidExpression(ExpressionParser.parse("- 3 + 4 / 2 +"))).isFalse()
        assertThat(InputValidator.isValidExpression(ExpressionParser.parse("1"))).isFalse()
    }
}
