package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `더하기 연산`() {
        val input = "2 + 3"
        val result = Calculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(5)
    }

    @Test
    fun `뺄셈 연산`() {
        val input = "100 - 1"
        val result = Calculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(99)
    }

    @Test
    fun `나누기 연산`() {
        val input = "20 / 2"
        val result = Calculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(10)
    }

    @Test
    fun `곱셈 연산`() {
        val input = "12 * 3"
        val result = Calculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(36)
    }

    @Test
    fun `사칙 연산`() {
        val input = "2 + 3 * 4 / 2"
        val result = Calculator.calculate(input)
        Assertions.assertThat(result).isEqualTo(10)
    }

    @Test
    fun `입력값이 null인 경우`() {
        val input = null
        assertThrows<IllegalArgumentException> {
            Calculator.calculate(input)
        }.localizedMessage shouldBe "입력값이 없습니다!!"
    }

    @Test
    fun `입력값이 공백 문자인 경우`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            Calculator.calculate(input)
        }.localizedMessage shouldBe "입력값이 없습니다!!"
    }

    @Test
    fun `사칙 연산 기호가 아닌 기호가 포함되어있는 경우`() {
        val input = "2 + 3 * 4 / 2 & 2"
        assertThrows<IllegalArgumentException> {
            Calculator.calculate(input)
        }.localizedMessage shouldBe "사칙연산 기호가 아닙니다. : &"
    }
}
