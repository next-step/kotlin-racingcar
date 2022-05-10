package calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t", "\n"])
    fun `null 또는 whitespace 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String?) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
            .withMessage("수식은 null 이거나 빈 공백 문자가 될 수 없습니다.")
    }

    @ParameterizedTest(name = "{index}) Invalid operand: {0}")
    @ValueSource(strings = ["1 % 1", "2 + 2 @ 2", "3 ^ 3", "4 ++"])
    fun `사칙연산 기호가 아닌 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
            .withMessageContaining("Invalid operand")
    }

    @ParameterizedTest(name = "{index}) Invalid number: {0}")
    @ValueSource(strings = ["a + b", "1,1 * 2"])
    fun `숫자가 아닌 문자가 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
            .withMessageContaining("Invalid number")
    }

    @ParameterizedTest(name = "{index}) Invalid expression: {0}")
    @ValueSource(strings = ["1 +", "- 2", "3 * / 3", "4 4 - 4", "5+5"])
    fun `잘못된 식이 주어질 경우 IllegalArgumentException 이 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(input) }
    }

    @ParameterizedTest(name = "{index}) {0} = {1}")
    @CsvSource(
        textBlock = """
        1 + 5 / 2 * 8 - 1,      23
        88 * 10 / 8 + 4,        114
        -3 * 4 - 90 + 44,       -58"""
    ) fun `사칙연산 - 덧셈, 뺄셈, 곱셈, 나눗셈 모두 포함`(expression: String, result: Int) {
        assertEquals(Calculator.calculate(expression), result)
    }
}
