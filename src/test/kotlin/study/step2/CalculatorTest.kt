package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `더하기`() {
        assertThat(Calculator().add(1, 2)).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        assertThat(Calculator().subtraction(3, 2)).isEqualTo(1)
    }

    @Test
    fun `곱하기`() {
        assertThat(Calculator().multiply(3, 5)).isEqualTo(15)
    }

    @Test
    fun `나누기`() {
        assertThat(Calculator().division(4, 2)).isEqualTo(2)
    }

    @Test
    fun `사칙 연산이 아닌 기호가 들어왔을때`() {
        val expression = listOf("2", "@", "3")
        assertThatThrownBy {
            Calculator().calculateExpression(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `처음 문자가 숫자가 아닐때`() {
        val expression = listOf("@", "2", "3")
        assertThatThrownBy {
            Calculator().calculateExpression(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `세번째 문자가 숫자가 아닐때`() {
        val expression = listOf("3", "3", "@")
        assertThatThrownBy {
            Calculator().calculateExpression(expression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
