package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
