package stringCalculatorTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import stringCalculator.StringOperator

class StringOperatorTest {
    @Test
    fun `연산자, 모든 피연산자가 모두 null이 아닌 경우에만 연산 수행`() {
        val stringOperator = StringOperator()
        stringOperator.numberProcess("3")
        stringOperator.operatorProcess("+")
        stringOperator.numberProcess("7")
        assertThat(stringOperator.getResult()).isEqualTo(10)
    }

    @Test
    fun `연산자가 null일 경우`() {
        val stringOperator = StringOperator()
        stringOperator.numberProcess("3")
        stringOperator.numberProcess("7")
        assertThat(stringOperator.getResult()).isEqualTo(0)
    }

    @Test
    fun `피연산자 하나가 null일 경우`() {
        val stringOperator = StringOperator()
        stringOperator.numberProcess("3")
        stringOperator.operatorProcess("+")
        assertThat(stringOperator.getResult()).isEqualTo(0)
    }
}
