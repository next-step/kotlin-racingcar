package calculator

import calculator.enums.ExceptionCode
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    private val calculator = Calculator()
    @Test
    @DisplayName("input에 null값이 들어오면 에러를 낸다")
    fun inputIsNotAllowedNull() {
        assertThatThrownBy {
            calculator.calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage())
    }

    @ParameterizedTest
    @DisplayName("input에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun inputIsNotAllowedEmpty(input: String?) {
        assertThatThrownBy {
            calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage())
    }

    @Test
    @DisplayName("숫자 위치에 숫자가 아니면 에러를 낸다")
    fun inputIsNotMatchNumeric() {
        assertThatThrownBy {
            calculator.calculate("a +")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())

        assertThatThrownBy {
            calculator.calculate("+ 1")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())

        assertThatThrownBy {
            calculator.calculate("( +")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())
    }

    @Test
    @DisplayName("연산자 위치에 연산자가 아니면 에러를 낸다")
    fun inputIsNotMatchOperator() {

        assertThatThrownBy {
            calculator.calculate("1 )")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())

        assertThatThrownBy {
            calculator.calculate("1 &")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())

        assertThatThrownBy {
            calculator.calculate("1 1 1")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
    }

    @Test
    @DisplayName("0으로 나누면 divide zero에러를 냅니다")
    fun notAllowedDivideZero() {

        assertThatThrownBy {
            calculator.calculate("1 / 0")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())

        assertThatThrownBy {
            calculator.calculate("10 / 0")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())

        assertThatThrownBy {
            calculator.calculate("1 * 2 + 3 / 0")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())
    }

    @Test
    @DisplayName("더하기 단항 연산을 성공한다")
    fun singlePlusSuccess() {
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3F)
        assertThat(calculator.calculate("10 + 20")).isEqualTo(30F)
        assertThat(calculator.calculate("4 + 5")).isEqualTo(9F)
        assertThat(calculator.calculate("11 + 2")).isEqualTo(13F)
        assertThat(calculator.calculate("0 + 2")).isEqualTo(2F)
    }

    @Test
    @DisplayName("빼기 단항 연산을 성공한다")
    fun singleMinusSuccess() {
        assertThat(calculator.calculate("1 - 2")).isEqualTo(-1F)
        assertThat(calculator.calculate("10 - 20")).isEqualTo(-10F)
        assertThat(calculator.calculate("4 - 5")).isEqualTo(-1F)
        assertThat(calculator.calculate("11 - 2")).isEqualTo(9F)
        assertThat(calculator.calculate("0 - 2")).isEqualTo(-2F)
    }

    @Test
    @DisplayName("곱하기 단항 연산을 성공한다")
    fun singleMultipleSuccess() {
        assertThat(calculator.calculate("1 * 2")).isEqualTo(2F)
        assertThat(calculator.calculate("10 * 20")).isEqualTo(200F)
        assertThat(calculator.calculate("4 * 5")).isEqualTo(20F)
        assertThat(calculator.calculate("11 * 2")).isEqualTo(22F)
        assertThat(calculator.calculate("0 * 2")).isEqualTo(0F)
    }

    @Test
    @DisplayName("나누기 단항 연산을 성공한다")
    fun singleDivideSuccess() {
        assertThat(calculator.calculate("1 / 2")).isEqualTo(0.5F)
        assertThat(calculator.calculate("10 / 20")).isEqualTo(0.5F)
        assertThat(calculator.calculate("4 / 5")).isEqualTo(0.8F)
        assertThat(calculator.calculate("11 / 2")).isEqualTo(5.5F)
        assertThat(calculator.calculate("0 / 2")).isEqualTo(0F)
    }

    @Test
    @DisplayName("복잡한 다항 연산을 성공한다")
    fun manyComplicatedOperationSuccess() {
        assertThat(calculator.calculate("1 * 2 + 3 - 1 / 2")).isEqualTo(2F)
    }
}
