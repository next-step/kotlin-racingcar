import ExceptionCase.Companion.CASE_DIVISION_NUMBER_ZERO
import ExceptionCase.Companion.CASE_INCORRECT_INPUT
import ExceptionCase.Companion.CASE_INCORRECT_SYMBOL
import ExceptionCase.Companion.CASE_INPUT_NULL_OR_EMPTY
import ExceptionCase.Companion.CASE_INT_FORMAT_OR_NULL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    @DisplayName("덧셈 계산")
    fun calculate_correct_when_plus() {
        val result = CalculateSymbol.PLUS.calculator(first = 3, second = 1)
        assertThat(result).isEqualTo(4)
    }

    @Test
    @DisplayName("뺄셈 계산")
    fun calculate_correct_when_minus() {
        val result = CalculateSymbol.MINUS.calculator(first = 3, second = 1)
        assertThat(result).isEqualTo(2)
    }

    @Test
    @DisplayName("나눗셈 계산")
    fun calculate_correct_when_division() {
        val result = CalculateSymbol.DiVISION.calculator(first = 15, second = 5)
        assertThat(result).isEqualTo(3)
    }

    @Test
    @DisplayName("0이 들어간 나눗셈")
    fun calculate_incorrect_when_division() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { CalculateSymbol.DiVISION.calculator(first = 15, second = 0) }
            .withMessage(CASE_DIVISION_NUMBER_ZERO)
    }

    @Test
    @DisplayName("곱셈 계산")
    fun calculate_correct_when_multiply() {
        val result = CalculateSymbol.MULTIPLY.calculator(first = 3, second = 5)
        assertThat(result).isEqualTo(15)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    @DisplayName("옮바른 계산식인 경우")
    fun calculate_correct(input: String) {
        val result = stringCalculator.calculate(input)
        assertThat(result).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 = 4 / 2", "10 & 3 / 5 + 1"])
    @DisplayName("사측연산 부호가 잘못 입력된 경우")
    fun calculate_when_symbol_incorrect(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator.calculate(input) }
            .withMessage(CASE_INCORRECT_SYMBOL)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 = 4 /", "10 & 3 / 5 +"])
    @DisplayName("숫자가 부족한 계산식인 경우")
    fun calculate_when_incorrect_input(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator.calculate(input) }
            .withMessage(CASE_INCORRECT_INPUT)
    }

    @ParameterizedTest
    @ValueSource(strings = ["g + 3 = 4", "ㅇ & 3 / ㄴ"])
    @DisplayName("계산할 수 없는 문자가 들어있는 경우")
    fun calculate_when_incorrect_input_type(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator.calculate(input) }
            .withMessage(CASE_INT_FORMAT_OR_NULL)
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("입력값이 null인 경우")
    fun calculate_when_input_is_null(input: String?) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator.calculate(input) }
            .withMessage(CASE_INPUT_NULL_OR_EMPTY)
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력값이 빈값인 경우")
    fun calculate_when_input_is_empty(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator.calculate(input) }
            .withMessage(CASE_INPUT_NULL_OR_EMPTY)
    }
}
