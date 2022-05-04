package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class SimpleCalculatorTest {

    @Test
    internal fun testForErrorCases() {

        val simpleCalculator = SimpleCalculator()

        // 연속 숫자 입력 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("3 3 + 2")
        }.hasMessageFindingMatch("continuous number")

        // null 입력 오류
        assertThatIllegalArgumentException().isThrownBy {
            simpleCalculator.evaluation(null)
        }

        // empty 입력 오류
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            simpleCalculator.evaluation("")
        }

        // blank 입력 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("          ")
        }.hasMessageFindingMatch("null or empty")

        // 연속 연산자 입력 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 + 3 * / 2")
        }.hasMessageFindingMatch("continuous operator")

        // 연속 연산자 입력 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 + 3 * / 2 + +")
        }.hasMessageFindingMatch("continuous operator")

        // 남는(불필요) 연산자 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 + 3 *    2 +")
        }.hasMessageFindingMatch("Needless operator")

        // 0 나누기 오류
        assertThatThrownBy {
            simpleCalculator.evaluation("+3 / 0 *    2 +")
        }.hasMessageFindingMatch("divide by 0")

        // 정의되지 않은 입력 a
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            simpleCalculator.evaluation("2 + a * 4 / 2")
        }

        // 정의되지 않은 입력 %
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            simpleCalculator.evaluation("2 + 3 % 4 / 2")
        }

        // 정의되지 않은 입력 %
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            simpleCalculator.evaluation("%2 + 3 * 4 / 2")
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
