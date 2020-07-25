package calculator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class InputValidatorTest {

    @Test
    fun isValidExpression() {
        assertTrue(InputValidator.isValidExpression(ExpressionParser.parse("3 + 4 / 2 + 5")))
        assertFalse(InputValidator.isValidExpression(ExpressionParser.parse("- 3 + 4 / 2 +")))
        assertFalse(InputValidator.isValidExpression(ExpressionParser.parse("1")))
    }
}
