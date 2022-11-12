package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["", "  "])
    fun `빈 공백 문자열`(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val stringCalculator = StringCalculator()
            stringCalculator.isNullOrBlank(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["   1 + 2 + 3   ", "1 +  2 +  3 "])
    fun `문자열 공백 처리`(input: String) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.removeSpace(input)
        assertThat(result).isEqualTo("1 + 2 + 3")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 - 3 * 4 / 5"])
    fun `띄어쓰기 1칸`(input: String) {
        val stringCalculator = StringCalculator()
        val (operand, operator) = stringCalculator.divideExpr(input)
        assertThat(operand == listOf(1, 2, 3, 4, 5)).isTrue
        assertThat(operator == listOf('+', '-', '*', '/')).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 +2 - 3", "1 +- 2 - 3"])
    fun `띄어쓰기 0칸 (인자가 붙어있는 경우)`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val stringCalculator = StringCalculator()
            val (operand, operator) = stringCalculator.divideExpr(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 # 2 & 3"])
    fun `사칙연산 기호가 아닌 기호`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val stringCalculator = StringCalculator()
            val (operand, operator) = stringCalculator.divideExpr(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2 + - 3 4"])
    fun `기호 간의 순서를 지키지 않음`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val stringCalculator = StringCalculator()
            val (operand, operator) = stringCalculator.divideExpr(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 - 3 * 4 /", "+ 1 + 2 - 3"])
    fun `숫자와 연산기호의 쌍이 맞지 않음`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val stringCalculator = StringCalculator()
            val (operand, operator) = stringCalculator.divideExpr(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 + 3 + 4", "2 + 3 * 4 / 2", "10 - 1 + 1 / 2 * 2"])
    fun `사칙 연산`(input: String) {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(10)
    }
}
