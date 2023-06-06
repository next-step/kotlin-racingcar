package step2

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    private val dut = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `empty string input throws IllegalArgumentException`(input: String) {
        assertThrows(IllegalArgumentException::class.java) { dut(input) }
    }
}
