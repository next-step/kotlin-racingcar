package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @Test
    fun success() {
        // arrange
        val calculator = StringCalculator()

        // act
        val result = calculator.execute("2 + 3 * 4 / 2")

        // assert
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun exception() {
        // arrange
        val calculator = StringCalculator()

        // act && assert
        assertThrows<StringCalculatorIllegalArgumentException> {
            calculator.execute("")
        }

        assertThrows<StringCalculatorIllegalArgumentException> {
            calculator.execute("1 == 1")
        }

        assertThrows<StringCalculatorIllegalArgumentException> {
            calculator.execute("0")
        }
    }
}
