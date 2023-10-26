package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["2:3:PLUS:5", "3:5:MINUS:-2", "1:3:MULTIPLY:3", "3:5:DIVIDE:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈`(currentResult: Int, nextValue: Int, operator: Operation, expect: Int) {
        // when
        val actual = Calculator.applyOperation(currentResult, nextValue, operator)

        // then
        assertThat(actual).isEqualTo(expect)
    }
}
