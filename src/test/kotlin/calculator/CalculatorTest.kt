package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `파라미터 값이 empty인 경우 예외처리한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.validInputIsEmpty("")
        }.withMessageMatching("입력 값이 존재하지 않습니다.")
    }

    @Test
    fun `입력한 값을 검사 후 split하여 리턴한다`() {
        val splitedInput = calculator.input("2 + 3")

        assertAll(
            { assertThat(splitedInput[0]).isEqualTo("2") },
            { assertThat(splitedInput[1]).isEqualTo("+") },
            { assertThat(splitedInput[2]).isEqualTo("3") }
        )
    }

    @Test
    fun `입력한 값을 split하여 리턴한다`() {
        val splitedInput = calculator.splitByWhiteSpace("5 * 2")

        assertAll(
            { assertThat(splitedInput[0]).isEqualTo("5") },
            { assertThat(splitedInput[1]).isEqualTo("*") },
            { assertThat(splitedInput[2]).isEqualTo("2") }
        )
    }

    @Test
    @DisplayName("3 * 10 / 5 을 연산하여 6을 리턴한다")
    fun `calculate_test`() {
        val splitedInput = calculator.input("3 * 10 / 5")
        val result = calculator.calculate(splitedInput)

        assertThat(result).isEqualTo(6)
    }

    @Test
    @DisplayName("5 + 3 * 2 / 4 을 연산하여 6을 리턴한다")
    fun `calculate_second_test`() {
        val splitedInput = calculator.input("5 + 3 * 2 / 4")
        val result = calculator.calculate(splitedInput)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `덧셈 연산자를 입력했을 때 더하기 연산을 한다`() {
        val result = calculator.applyOperator(0, 10, "+")

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `잚못된 입력했을 때 예외처리한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.applyOperator(0, 10, "&")
        }.withMessageMatching("잘못된 연산자입니다.")
    }

    @Test
    fun `덧셈 연산이 처리되어 결과를 리턴한다`() {
        // when
        val answer = calculator.add(2, 3)

        // then
        assertThat(answer).isEqualTo(5)
    }

    @Test
    fun `뺄셈의 결과가 양수인 경우 양수의 값을 리턴한다`() {
        // when
        val answer = calculator.minus(10, 5)

        // then
        assertThat(answer).isEqualTo(5)
    }

    @Test
    fun `뺄셈의 결과가 음수인 경우 음수의 값을 리턴한다`() {
        // when
        val answer = calculator.minus(5, 6)

        // then
        assertThat(answer).isEqualTo(-1)
    }

    @Test
    fun `곱셈 연산 처리되어 결과를 리턴한다`() {
        // when
        val answer = calculator.multiply(2, 3)

        // then
        assertThat(answer).isEqualTo(6)
    }

    @Test
    fun `나눗셈을 처리하여 결과를 리턴한다`() {
        // when
        val answer = calculator.division(10, 5)

        // then
        assertThat(answer).isEqualTo(2)
    }

    @Test
    fun `나눗셈을 처리 시 분모가 0인경우 예외처리한다`() {
        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.division(10, 0)
        }.withMessageMatching("0은 분모가 될 수 없습니다.")
    }
}
