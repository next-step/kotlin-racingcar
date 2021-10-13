package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    internal fun setUp() {
        calculator = Calculator()
    }

    @DisplayName("Calculator 인스턴스 생성 여부 테스트")
    @Test
    fun constructor_test() {
        // given and when
        val calculator = Calculator()

        // then
        assertAll(
            { assertThat(calculator).isNotNull },
            { assertThat(calculator).isExactlyInstanceOf(Calculator::class.java) },
        )
    }

    // null 입력시 예외처리라고 되어있는데, 애초에 non-nullable 로 처리해서 null 은 테스트 안 했습니다.
    @DisplayName("Calculator 인스턴스 공백 연산시 예외 발생 테스트")
    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["", " "])
    fun blank_calculate_test(expression: String) {
        // when and then
        assertThatThrownBy { calculator.calculate(expression) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Calculator.EXPRESSION_NULL_MESSAGE)
    }

    @DisplayName("Calculator 인스턴스 단일 값 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}")
    @CsvSource(value = ["-1:-1", "0:0", "1:1"], delimiter = ':')
    fun single_value_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 덧셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 + 3:5", "-1 + 1:0", "10 + -3:7", "10 + 5:15", "0 + 0:0"], delimiter = ':')
    fun add_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 뺄샘 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 - 3:-1", "-1 - -1:0", "0 - 0:0", "10 - 7:3", "-0 - -0:0"], delimiter = ':')
    fun subtract_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 곱셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 * 3:6", "-1 * -1:1", "0 * 0:0", "32 * 7:224", "-0 * -0:0"], delimiter = ':')
    fun multiply_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 나눗셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["10 / 5:2", "100 / 10:10", "10 / -10:-1", "32 / 4:8", "-1 / -1:1"], delimiter = ':')
    fun divide_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 나머지 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["10 % 5:0", "100 % 9:1", "32 % 3:2", "1 % 1:0"], delimiter = ':')
    fun mod_test(expression: String, expected: Int) {
        // given and when
        val actual = calculator.calculate(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 복합 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(
        value = ["10 / 5 * 2 + 5 - 1:8", "12 + 10 - 2 / 4 * 10:50", "-1 - -10 * 5 + 5 / 10:5", "0 - 0 + 0 * 0 / 1:0"],
        delimiter = ':'
    )
    fun calculatorTest(expression: String?, expect: Int) {
        // given and when
        val result = calculator.calculate(expression!!)

        // then
        assertThat(result).isEqualTo(expect)
    }
}
