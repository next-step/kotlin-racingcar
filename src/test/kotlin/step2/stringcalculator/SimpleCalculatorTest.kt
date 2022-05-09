package step2.stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SimpleCalculatorTest {

    @Test
    internal fun testForDivideByZeroError() {
        val simpleCalculator = SimpleCalculator()
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 / 0 *    2 +")
        }.hasMessageFindingMatch("divide by 0")
    }

    @Test
    internal fun testForNeedlessOperatorError() {
        val simpleCalculator = SimpleCalculator()
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 + 3 *    2 +")
        }.hasMessageFindingMatch("Needless operator")
    }

    @Test
    internal fun testForContinuousNumberError() {
        val simpleCalculator = SimpleCalculator()
        assertThatThrownBy {
            simpleCalculator.evaluation("3 3 + 2")
        }.hasMessageFindingMatch("continuous number")
    }

    @Test
    internal fun testForNullError() {
        val simpleCalculator = SimpleCalculator()
        assertThatIllegalArgumentException().isThrownBy {
            simpleCalculator.evaluation(null)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "      "])
    internal fun testForEmptyBlankError(testCase: String) {
        val simpleCalculator = SimpleCalculator()
        assertThatThrownBy {
            simpleCalculator.evaluation("          ")
        }.hasMessageFindingMatch("null or empty")
    }

    @ParameterizedTest
    @ValueSource(strings = ["+3 + 3 * / 2", "+3 + 3 * / 2 + +"])
    internal fun testForContinuousOperatorError(testCase: String) {
        val simpleCalculator = SimpleCalculator()
        assertThatThrownBy {
            simpleCalculator.evaluation(testCase)
        }.hasMessageFindingMatch("continuous operator")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + a * 4 / 2", "2 + 3 % 4 / 2", "%2 + 3 * 4 / 2"])
    internal fun testForUnexpectedTokenError(testCase: String) {
        val simpleCalculator = SimpleCalculator()
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            simpleCalculator.evaluation(testCase)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + 3 * 4 / 2, 10.0", // Normal case
            "+2 + +3 * 4 / 2, 10.0", // Signed number case
            "2 + 3.0 * +4 / +2.0, 10.0", // Double number case
            "2 + -3 * 4 / 2, -2.0"
        ]
    )
    internal fun testForCalculation(testCase: String) {

        val arguments = testCase.split(",")
        val expression = arguments[0]
        val expectation = arguments[1].toDouble()

        val simpleCalculator = SimpleCalculator()
        assertThat(simpleCalculator.evaluation(expression)).isEqualTo(expectation)
    }
}
