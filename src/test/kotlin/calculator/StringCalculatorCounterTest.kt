package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class StringCalculatorCounterTest {

    @Test
    fun calculate() {
        // given
        val input : String = "2 + 3 * 4 / 2"

        // when
        val stringCalculatorCounter = StringCalculatorCounter(input)
        val result = stringCalculatorCounter.calculate()

        // then
        assertThat(result).isEqualTo(10.0)
    }


    @Test
    fun invalidInput(){
        // given
        val input : String = "1 + + 2"

        // when // then
        val exception = assertThrows<IllegalArgumentException> {
            val stringCalculatorCounter = StringCalculatorCounter(input)
            val result = stringCalculatorCounter.calculate()
        }
        assertThat(exception.message).isEqualTo("Please Check the Input")
    }

    @Test
    fun invalidInputIncludeNotSymbol(){
        // given
        val input : String = "1 + 2 A 3"

        // when // then
        val exception = assertThrows<IllegalArgumentException> {
            val stringCalculatorCounter = StringCalculatorCounter(input)
            val result = stringCalculatorCounter.calculate()
        }
        assertThat(exception.message).isEqualTo("Please Check the Input")
    }
}
