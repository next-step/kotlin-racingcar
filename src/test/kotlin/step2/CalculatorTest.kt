package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `1 add 1`() {
        val x = BigDecimal("1")
        val y = BigDecimal("1")

        val result = calculator.add(x, y)

        assertThat(result).isEqualTo(BigDecimal("2"))
    }

    @Test
    fun `2 subtract 1`() {
        val x = BigDecimal("2")
        val y = BigDecimal("1")

        val result = calculator.subtract(x, y)

        assertThat(result).isEqualTo(BigDecimal("1"))
    }

    @Test
    fun `1 multiply 2`() {
        val x = BigDecimal("1")
        val y = BigDecimal("2")

        val result = calculator.multiply(x, y)

        assertThat(result).isEqualTo(BigDecimal("2"))
    }

    @Test
    fun `4 divide 2`() {
        val x = BigDecimal("4")
        val y = BigDecimal("2")

        val result = calculator.divide(x, y)

        assertThat(result).isEqualTo(BigDecimal("2"))
    }
}
