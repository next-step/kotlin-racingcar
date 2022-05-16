package calculator

import StringCalculator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `입력값이 null인 경우`() {
        assertThatThrownBy {
            calculator.calculate(null)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 null 혹은 빈 값입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 blank인 경우`(input: String) {
        assertThatThrownBy {
            calculator.calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 null 혹은 빈 값입니다.")
    }
}
