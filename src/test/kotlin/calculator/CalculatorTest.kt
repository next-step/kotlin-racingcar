package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun add() {
        var input = "2 + 4"

        val result = add(input)

        assertThat(result).isEqualTo(6)
    }
}
