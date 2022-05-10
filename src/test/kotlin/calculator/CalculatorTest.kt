package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorTest {


    @ParameterizedTest
    @CsvSource(
        "1 + 2 + 3, 6",
        "10 + 30, 40"
    )
    fun `뎃셈 연산`(expression: String, expect: Int) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(
        "1 - 2 - 3, -4",
        "10 - 30, -20",
        "0 - 1 - 2, -3",
    )
    fun `뺄셈 연산`(expression: String, expect: Int) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expect)
    }


    @ParameterizedTest
    @CsvSource(
        "1 * 2 * 3, 6",
        "10 * 30, 300",
        "0 * 1 * 2, 0",
    )
    fun `곱센 연산`(expression: String, expect: Int) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(
        "100 / 10 / 10, 1",
        "100 / 20, 5"
    )
    fun `나눗셈 연산`(expression: String, expect: Int) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(
        "1 + 2 + 3 - 6 + 1 * 10 / 10, 1",
        "10 - 9 * 10 / 10 * 3, 3",
    )
    fun `복합 연산`(expression: String, expect: Int) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expect)
    }


    @Test
    fun `0 Arithmetic 나눗셈`() {
        assertThrows<ArithmeticException> {
            Calculator.calculate("100 / 0")
        }
    }

    @Test
    fun `계산 표현식 빈스트링 Exception 발생`() {
        assertThrows<IllegalArgumentException> { assertThat(Calculator.calculate("")) }
    }

    @Test
    fun `계산 표현식 Null Exception 발생`() {
        assertThrows<IllegalArgumentException> { assertThat(Calculator.calculate(null)) }
    }

    @Test
    fun `미제공 표현식`() {
        assertThrows<IllegalArgumentException> { assertThat(Calculator.calculate("1!@#2")) }
        assertThrows<IllegalArgumentException> { assertThat(Calculator.calculate("1**+1")) }
    }
}
