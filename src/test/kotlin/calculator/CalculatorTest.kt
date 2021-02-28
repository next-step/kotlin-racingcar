package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @Test
    fun `파라미터 값이 empty인 경우 예외처리한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.validInputIsEmpty("")
        }.withMessageMatching("입력 값이 존재하지 않습니다.")
    }

    @Test
    fun `입력한 값을 검사 후 split하여 리턴한다`() {
        val splitedInput = Calculator.input("2 + 3")

        assertAll(
            { assertThat(splitedInput[0]).isEqualTo("2") },
            { assertThat(splitedInput[1]).isEqualTo("+") },
            { assertThat(splitedInput[2]).isEqualTo("3") }
        )
    }

    @Test
    fun `입력한 값을 split하여 리턴한다`() {
        val splitedInput = Calculator.splitByWhiteSpace("5 * 2")

        assertAll(
            { assertThat(splitedInput[0]).isEqualTo("5") },
            { assertThat(splitedInput[1]).isEqualTo("*") },
            { assertThat(splitedInput[2]).isEqualTo("2") }
        )
    }

    @ParameterizedTest
    @CsvSource("3 * 10 / 5, 6", "5 + 3 * 2 / 4", "4")
    fun `입력받은 문자열을 calculate로 순차적으로 계산하여 결과를 리턴한다`(input: String, expectedResult: Int) {
        val splitedInput = Calculator.input("3 * 10 / 5")
        val result = Calculator.calculate(splitedInput)

        assertThat(result).isEqualTo(6)
    }

    @Test
    @DisplayName("5 + 3 * 2 / 4 을 연산하여 6을 리턴한다")
    fun `calculate_second_test`() {
        val splitedInput = Calculator.input("5 + 3 * 2 / 4")
        val result = Calculator.calculate(splitedInput)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `덧셈 연산자를 입력했을 때 더하기 연산을 한다`() {
        val result = Calculator.applyOperator(0, 10, Operator.PLUS)

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `덧셈 연산이 처리되어 결과를 리턴한다`() {
        // when
        val answer = Calculator.add(2, 3)

        // then
        assertThat(answer).isEqualTo(5)
    }

    @Test
    fun `뺄셈의 결과가 양수인 경우 양수의 값을 리턴한다`() {
        // when
        val answer = Calculator.minus(10, 5)

        // then
        assertThat(answer).isEqualTo(5)
    }

    @Test
    fun `뺄셈의 결과가 음수인 경우 음수의 값을 리턴한다`() {
        // when
        val answer = Calculator.minus(5, 6)

        // then
        assertThat(answer).isEqualTo(-1)
    }

    @Test
    fun `곱셈 연산 처리되어 결과를 리턴한다`() {
        // when
        val answer = Calculator.multiply(2, 3)

        // then
        assertThat(answer).isEqualTo(6)
    }

    @Test
    fun `나눗셈을 처리하여 결과를 리턴한다`() {
        // when
        val answer = Calculator.division(10, 5)

        // then
        assertThat(answer).isEqualTo(2)
    }

    @Test
    fun `나눗셈을 처리 시 분모가 0인경우 예외처리한다`() {
        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.division(10, 0)
        }.withMessage("0은 분모가 될 수 없습니다.")
    }
}
