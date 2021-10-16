package step2.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.domain.expression.Expression
import step2.domain.expression.Operand

class CalculatorTest {

    @DisplayName("Calculator 인스턴스 단일 값 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}")
    @CsvSource(value = ["-1:-1", "0:0", "1:1"], delimiter = ':')
    fun single_value_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 덧셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 + 3:5", "-1 + 1:0", "10 + -3:7", "10 + 5:15", "0 + 0:0"], delimiter = ':')
    fun add_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 뺄샘 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 - 3:-1", "-1 - -1:0", "0 - 0:0", "10 - 7:3", "-0 - -0:0"], delimiter = ':')
    fun subtract_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 곱셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["2 * 3:6", "-1 * -1:1", "0 * 0:0", "32 * 7:224", "-0 * -0:0"], delimiter = ':')
    fun multiply_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 나눗셈 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["10 / 5:2", "100 / 10:10", "10 / -10:-1", "32 / 4:8", "-1 / -1:1"], delimiter = ':')
    fun divide_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 나머지 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(value = ["10 % 5:0", "100 % 9:1", "32 % 3:2", "1 % 1:0"], delimiter = ':')
    fun mod_test(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Calculator 인스턴스 복합 연산 기능 테스트")
    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @CsvSource(
        value = ["10 / 5 * 2 + 5 - 1:8", "12 + 10 - 2 / 4 * 10:50", "-1 - -10 * 5 + 5 / 10:5", "0 - 0 + 0 * 0 / 1:0"],
        delimiter = ':'
    )
    fun calculatorTest(lawExpression: String, lawExpected: Int) {
        // given
        val expression = Expression(lawExpression)
        val expected = Operand(lawExpected)

        // when
        val actual = Calculator.calculate(expression) { target -> target.split(" ") }

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
