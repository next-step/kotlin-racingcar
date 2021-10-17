package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import step2.module.CalculatorParser

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `어노테이션을 테스트 한다`(str: String) {
        assertTrue(str.isNotBlank())
    }

    @ParameterizedTest
    @CsvSource(value = ["10, 11., 21.", "31.5, 33.7, 65.2"], delimiterString = ", ")
    fun `덧셈을 테스트 한다`(firstNum: Double, secondNum: Double, result: Double) {
        assertThat(Operator.SUM.expression(firstNum, secondNum)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["21, 11, 10", "21.0, 21.5, -0.5", "31, 32, -1"], delimiterString = ", ")
    fun `뺄셈을 테스트 한다`(firstNum: Double, secondNum: Double, result: Double) {
        assertThat(Operator.SUBTRACTION.expression(firstNum, secondNum)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["9, 9, 81", "10, 10, 100", "457, 851, 388907"], delimiterString = ", ")
    fun `곱셈을 테스트 한다`(firstNum: Double, secondNum: Double, result: Double) {
        assertThat(Operator.MULTIPLY.expression(firstNum, secondNum)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["9, 3, 3", "987521, 2, 493760.5"], delimiterString = ", ")
    fun `나눗셈을 테스트 한다`(firstNum: Double, secondNum: Double, result: Double) {
        assertThat(Operator.DIVIDE.expression(firstNum, secondNum)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2, 10", "3 + 10 * 7 / 10, 9.1"], delimiterString = ", ")
    fun `계산기의 모든 기능을 테스트 한다`(input: String, result: Double) {
        val calculator = Calculator(CalculatorParser())
        assertThat(calculator.running(input)).isEqualTo(result)
    }
}
