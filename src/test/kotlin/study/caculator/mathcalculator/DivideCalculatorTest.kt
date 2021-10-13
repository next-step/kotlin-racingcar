package study.caculator.mathcalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import study.calculator.mathcalculator.DivideCalculator

internal class DivideCalculatorTest {

    @Test
    fun `0인 값으로 나눌시 예외를 던진다`() {
        val divideCalculator = DivideCalculator()
        val x = 10
        val y = 0

        Assertions.assertThatCode { divideCalculator.calculate(x, y) }
            .isInstanceOf(ArithmeticException::class.java)
    }
}
