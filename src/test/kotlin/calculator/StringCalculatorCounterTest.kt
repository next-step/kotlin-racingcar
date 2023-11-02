package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorCounterTest {

    @Test
    fun calculate() {
        // given
        val input: String = "2 + 3 * 4 / 2"
        val stringCalculatorCounter = StringCalculatorCounter()
        // when

        val result = stringCalculatorCounter.calculate(input)

        // then
        assertThat(result).isEqualTo(10.0)
    }

    @Test
    fun invalidInput() {
        // given
        val input: String = "1 + + 2"
        val stringCalculatorCounter = StringCalculatorCounter()
        // when // then
        val exception = assertThrows<IllegalArgumentException> {
            val result = stringCalculatorCounter.calculate(input)
        }
        assertThat(exception.message).isEqualTo("Please Check the Input")
    }

    @Test
    fun invalidInputIncludeNotSymbol() {
        // given
        val input: String = "1 + 2 A 3"
        val stringCalculatorCounter = StringCalculatorCounter()

        // when // then
        val exception = assertThrows<IllegalArgumentException> {
            val result = stringCalculatorCounter.calculate(input)
        }
        assertThat(exception.message).isEqualTo("Please Check the Input")
    }
}
