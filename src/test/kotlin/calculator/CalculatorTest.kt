package calculator

import calculator.parser.InputParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculatorTest() {
        assertThat(Calculator(InputParser).run("3 + 4 / 1")).isEqualTo(7.0)
    }
}
