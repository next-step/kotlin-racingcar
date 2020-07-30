package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun `check add`() {
        assertThat(Calculator.calculate("1 + 3")).isEqualTo("4")
    }

    @Test
    fun `check subtract`() {
        assertThat(Calculator.calculate("1 - 4")).isEqualTo("-3")
    }

    @Test
    fun `check multiply`() {
        assertThat(Calculator.calculate("1 + 3")).isEqualTo("4")
    }

    @Test
    fun `check divide`() {
        assertThat(Calculator.calculate("4 / 2")).isEqualTo("2")
    }

    @Test
    fun `check blank validation`() {
        assertThatThrownBy { Calculator.calculate("4 / 0") }
            .isInstanceOf(ArithmeticException::class.java)
    }

    @Test
    fun `check empty string`() {
        assertThatThrownBy { Calculator.calculate("") }
            .isInstanceOf(CalculatorException::class.java)
    }

    @Test
    fun `check null`() {
        assertThatThrownBy { Calculator.calculate(null) }
            .isInstanceOf(CalculatorException::class.java)
    }

    @Test
    fun `check number symbol order`() {
        assertThatThrownBy { Calculator.calculate("2 3") }
            .isInstanceOf(CalculatorException::class.java)
    }

    @Test
    fun `check symbol`() {
        assertThatThrownBy { Calculator.calculate("2 $ 3") }
            .isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `check blank error`() {
        assertThatThrownBy { Calculator.calculate("2*3") }
            .isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `result single equation`() {
        assertThat(Calculator.calculate("2")).isEqualTo("2")
    }

    @Test
    fun `result multiple equation`() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo("10")
    }
}
