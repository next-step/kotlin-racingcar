import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTests {
    @Test
    fun `validateStringForCalculate`() {
        val stringCalculator = StringCalculator()
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate(null)
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate(" !@")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("!@  ")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("abcd")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("!@#$")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("1234")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("1234+5678")
        }

        assertTrue(stringCalculator.validateStringForCalculate("1234 + 5678") is Unit)
    }

    @Test
    fun `splitForCalculate`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.splitForCalculate("1234 + 5678 / 31")).isNotEmpty
    }
}
