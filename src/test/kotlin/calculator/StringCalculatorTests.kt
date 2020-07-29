package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTests {
    lateinit var stringCalculator: StringCalculator

    @BeforeEach
    fun init() {
        stringCalculator = StringCalculator()
    }

    @Test
    fun `validateStringForCalculateThrowByNull`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate(null)
        }
    }

    @Test
    fun `validateStringForCalculateThrowByNoSpace`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("")
        }
    }

    @Test
    fun `validateStringForCalculateThrowByInvalidSymbol`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate(" !@")
        }
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("!@#$")
        }
    }

    @Test
    fun `validateStringForCalculateThrowByAlphabet`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("abcd")
        }
    }

    @Test
    fun `validateStringForCalculateThrowByOnlyNumber`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("1234")
        }
    }

    @Test
    fun `validateStringForCalculateThrowByNoBlank`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.validateStringForCalculate("1234+5678")
        }
    }

    @Test
    fun `validStringNotThrowException`() {
        assertDoesNotThrow({ stringCalculator.validateStringForCalculate("1234 + 5678") })
    }

    @Test
    fun `splitForCalculate`() {
        assertThat(stringCalculator.splitForCalculate("1234 + 5678 / 31")).isNotEmpty
    }

    @Test
    fun `plus`() {
        var list = listOf("1234", "+", "4567", "+", "5678")
        val result = stringCalculator.calculate(list)
        assertThat(result).isEqualTo(1234 + 4567 + 5678)
    }

    @Test
    fun `minus`() {
        var list = listOf("1234", "-", "4567", "-", "5678")
        val result = stringCalculator.calculate(list)
        assertThat(result).isEqualTo(1234 - 4567 - 5678)
    }

    @Test
    fun `multiply`() {
        var list = listOf("1234", "*", "4567", "*", "5678")
        val result = stringCalculator.calculate(list)
        assertThat(result).isEqualTo(1234 * 4567 * 5678)
    }

    @Test
    fun `divide`() {
        var list = listOf("1234", "/", "4567", "/", "5678")
        val result = stringCalculator.calculate(list)
        assertThat(result).isEqualTo(1234 / 4567 / 5678)
    }

    @Test
    fun `divide by zero not execute`() {
        var listDivideByZero = listOf("1234", "/", "0")
        assertThrows<ArithmeticException> {
            stringCalculator.calculate(listDivideByZero)
        }
    }
}
