package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3", "3 + 2", "1 + 1 + 3"])
    fun `덧셈 연산이 처리되어 결과를 리턴한다`(input: String) {
        // when
        val answer = calculator.add(input)

        // then
        assertThat(answer).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5 - 3", "10 - 4 - 4"])
    fun `뺄셈의 결과가 양수인 경우 양수의 값을 리턴한다`(input: String) {
        // when
        val answer = calculator.minus(input)

        // then
        assertThat(answer).isEqualTo(-1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 - 3", "20 - 21"])
    fun `뺄셈의 결과가 음수인 경우 음수의 값을 리턴한다`(input: String) {
        // when
        val answer = calculator.minus(input)

        // then
        assertThat(answer).isEqualTo(-1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 * 3", "3 * 2", "1 * 2 * 3"])
    fun `곱셈 연산 처리되어 결과를 리턴한다`(input: String) {
        // when
        val answer = calculator.multiply(input)

        // then
        assertThat(answer).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10 / 5", "20 / 10"])
    fun `나눗셈을 처리하여 결과를 리턴한다`(input: String) {
        // when
        val answer = calculator.division(input)

        // then
        assertThat(answer).isEqualTo(2)
    }

    @Test
    fun `나눗셈을 처리 시 분모가 0인경우 예외처리한다`() {
        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            calculator.division("10 / 0")
        }.withMessageMatching("0은 분모가 될 수 없습니다.")
    }
}
