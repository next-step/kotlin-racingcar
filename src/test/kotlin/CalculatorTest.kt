import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {


    @Test
    fun `뎃셈 연산`() {
        assertThat(Calculator.operate("1 + 2 + 3")).isEqualTo(6)
        assertThat(Calculator.operate("10 + 30")).isEqualTo(40)
        assertThat(Calculator.operate("0 + 1 + 2")).isEqualTo(3)
    }

    @Test
    fun `뺄셈 연산`() {
        assertThat(Calculator.operate("1 - 2 - 3")).isEqualTo(-4)
        assertThat(Calculator.operate("10 - 30")).isEqualTo(-20)
        assertThat(Calculator.operate("0 - 1 - 2")).isEqualTo(-3)
    }


    @Test
    fun `곱센 연산`() {
        assertThat(Calculator.operate("1 * 2 * 3")).isEqualTo(6)
        assertThat(Calculator.operate("10 * 30")).isEqualTo(300)
        assertThat(Calculator.operate("0 * 1 * 2")).isEqualTo(0)
    }

    @Test
    fun `나눗셈 연산`() {
        assertThat(Calculator.operate("100 / 10 / 10")).isEqualTo(1)
        assertThat(Calculator.operate("100 / 20")).isEqualTo(5)
    }


    @Test
    fun `0 Arithmetic 나눗셈`() {
        assertThrows<ArithmeticException> {
            Calculator.operate("100 / 0")
        }
    }

    @Test
    fun `expression null or empty`() {
        assertThrows<IllegalArgumentException> { assertThat(Calculator.operate("")) }
        assertThrows<IllegalArgumentException> { assertThat(Calculator.operate(null)) }
    }

    @Test
    fun `illegal expression`() {
        assertThrows<IllegalArgumentException> { assertThat(Calculator.operate("1!@#2")) }
        assertThrows<IllegalArgumentException> { assertThat(Calculator.operate("1**+1")) }
    }
}
