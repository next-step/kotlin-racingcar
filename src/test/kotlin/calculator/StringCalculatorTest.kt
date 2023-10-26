package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun nullTest(input: String?) {
        val stringCalculator = StringCalculator()
        assertThatThrownBy { stringCalculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun wrongOperationTest() {
        val stringCalculator = StringCalculator()
        assertThatThrownBy { stringCalculator.calculate("1 @ 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("1 + 2, 3", "2 - 1, 1", "2 * 3, 6", "6 / 3, 2", "2 + 3 * 4 / 2, 10")
    fun calculateTest(input: String, result: Int) {
        val stringCalculator = StringCalculator()
        val calculate = stringCalculator.calculate(input)
        assertThat(calculate).isEqualTo(result)
    }
}
