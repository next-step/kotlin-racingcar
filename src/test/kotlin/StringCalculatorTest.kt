import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class StringCalculatorTest {

    @Test
    fun `입력값으로 공백문자가 전달되면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값으로 입렵 문자열 첫번째가 숫자가 아니면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("n+1")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값으로 사칙연산 기호 오른쪽이 숫자가 아니면 예외가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("1+n")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산이 주어지지 않을 경우 예외가 발생한다`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("1]n")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("getPlusTestData")
    fun `덧셈 기능 테스트`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("getMinusTestData")
    fun `뺄셈 기능 테스트`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("getDivisionTestData")
    fun `나눗셈 기능 테스트`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("getMultipleTestData")
    fun `곱하기 기능 테스트`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("getCalculatorTestData")
    fun `전체 기능 테스트`(input: String, result: Int) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun getPlusTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "1 + 1", 2
                ),
                Arguments.of(
                    "33 + 7", 40
                ),
                Arguments.of(
                    "12 + 1", 13
                )
            )
        }

        @JvmStatic
        fun getMinusTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "1 - 1", 0
                ),
                Arguments.of(
                    "33 - 7", 26
                ),
                Arguments.of(
                    "12 - 1", 11
                )
            )
        }

        @JvmStatic
        fun getDivisionTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "1 / 1", 1
                ),
                Arguments.of(
                    "33 / 7", 4
                ),
                Arguments.of(
                    "12 / 1", 12
                )
            )
        }

        @JvmStatic
        fun getMultipleTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "1 * 1", 1
                ),
                Arguments.of(
                    "33 * 7", 231
                ),
                Arguments.of(
                    "12 * 1", 12
                )
            )
        }
        @JvmStatic
        fun getCalculatorTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    "2 + 3 * 4 / 2", 10
                ),
                Arguments.of(
                    "1 * 3 + 4 / 1", 7
                ),
            )
        }
    }
}
