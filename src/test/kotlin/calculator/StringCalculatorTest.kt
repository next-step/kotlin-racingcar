package calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `입력값이 없으면 IllegalArgumentException이 발생합니다`() {
        val input: String? = null;

        val stringCalculator: StringCalculator = StringCalculator()

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }
}