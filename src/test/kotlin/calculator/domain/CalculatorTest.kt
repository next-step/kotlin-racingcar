package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `올바른 문자열 계산`() {

        val list = listOf("2", "+", "3", "*", "4", "/", "2")

        assertThat(calculator.calculate(list)).isEqualTo(10.0)
    }

    @Test
    fun `사칙연산이 아닌 연산자 포함`() {

        val list = listOf("2", "A", "3", "*", "4", "/", "2")

        assertThrows<IllegalArgumentException> {
            calculator.calculate(list)
        }
    }
}
