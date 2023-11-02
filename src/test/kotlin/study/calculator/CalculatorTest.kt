package study.calculator

import calculator.Calculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `덧셈`() {
        val calculator = Calculator("1 + 2")
        val result = calculator.calculate()
        result shouldBe 3
    }

    @Test
    fun `뺄셈`() {
        val calculator = Calculator("1 - 2")
        val result = calculator.calculate()
        result shouldBe -1
    }

    @Test
    fun `곱셈`() {
        val calculator = Calculator("1 * 2")
        val result = calculator.calculate()
        result shouldBe 2
    }

    @Test
    fun `나눗셈`() {
        val calculator = Calculator("4 / 2")
        val result = calculator.calculate()
        result shouldBe 2
    }

    @Test
    fun `사칙연산`() {
        val calculator = Calculator("2 + 3 * 4 / 2")
        val result = calculator.calculate()
        result shouldBe 10
    }

    @Test
    fun `익셉션`() {
        val calculator = Calculator("2 + 3 A * 4 / 2")
        shouldThrow<IllegalArgumentException> {
            calculator.calculate()
        }

        val calculator2 = Calculator("2 + 3 * 4 / * 1")
        shouldThrow<IllegalArgumentException> {
            calculator2.calculate()
        }

        val calculator3 = Calculator("2 + 3 * 4 2 0")
        shouldThrow<IllegalArgumentException> {
            calculator3.calculate()
        }
    }
}
