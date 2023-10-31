package calculator.validator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperationValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2", "1 + 2 * 5", "1 + 2 * 5 / 3", "1 + 2 * 5 / 3 - 1"])
    fun `정상케이스`(expression: String) {
        assertTrue(OperationValidator.isCorrectExpression(expression))
    }

    @ParameterizedTest
    @EmptySource
    fun `empty expression 인 경우, return false`(expression: String) {
        assertFalse(OperationValidator.isCorrectExpression(expression))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 ** 5", "1 + 2 ** 5 /", "1 ++ 2", "1 + 2 -", "+ 1 + 2"])
    fun `잘못된 expression 인 경우, return false`(expression: String) {
        assertFalse(OperationValidator.isCorrectExpression(expression))
    }
}
