package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["", "1 == 1", "0"])
    fun exception(candidate: String) {
        // arrange
        val calculator = StringCalculator()

        // act && assert
        assertThrows<InvalidCalculatorInput> {
            calculator.execute(candidate)
        }

        assertThrows<InvalidCalculatorInput> {
            calculator.execute(candidate)
        }

        assertThrows<InvalidCalculatorInput> {
            calculator.execute(candidate)
        }
    }
}
