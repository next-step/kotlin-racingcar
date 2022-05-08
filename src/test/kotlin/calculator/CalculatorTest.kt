package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `정상 입력`() {
        val calculator = Calculator()
        assertThat(calculator.input("1111 * 2 + 1 - 3 / 2")).isEqualTo(1110)
        assertThat(calculator.input("1111 * 2 * 10 * 3 * 2")).isEqualTo(133320)
        assertThat(calculator.input("1111 + -2 + 10 + 3 * 2")).isEqualTo(2244)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자인 경우`() {
        val calculator = Calculator()
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input("")
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input(null)
        }
    }

    @Test
    fun `사칙연산이 아닌 문자열이 포함`() {
        val calculator = Calculator()

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input("1111 + 2 * a")
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input("1111 + 2 qq")
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input("q1111 + 2")
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.input("12 q 1111 + 2")
        }
    }

    @Test
    fun `덧셈`() {
        val calculator = Calculator()
        assertThat(calculator.input("1111 + 2")).isEqualTo(1113)
        assertThat(calculator.input("1111 + 02")).isEqualTo(1113)
        assertThat(calculator.input("1111 + -02")).isEqualTo(1109)
        assertThat(calculator.input("-1111 + -2")).isEqualTo(-1113)
    }

    @Test
    fun `뺄셈`() {
        val calculator = Calculator()
        assertThat(calculator.input("1111 - 2")).isEqualTo(1109)
        assertThat(calculator.input("-1111 - 2")).isEqualTo(-1113)
        assertThat(calculator.input("-1111 - -02")).isEqualTo(-1109)
        assertThat(calculator.input("-1111 - -2")).isEqualTo(-1109)
    }

    @Test
    fun `곱셈`() {
        val calculator = Calculator()
        assertThat(calculator.input("1111 * 2")).isEqualTo(2222)
        assertThat(calculator.input("1111 * 02")).isEqualTo(2222)
        assertThat(calculator.input("-1111 * 2")).isEqualTo(-2222)
        assertThat(calculator.input("-1111 * -2")).isEqualTo(2222)
    }

    @Test
    fun `나눗셈`() {
        val calculator = Calculator()
        assertThat(calculator.input("1111 / 2")).isEqualTo(555)
        assertThat(calculator.input("1111 / 02")).isEqualTo(555)
        assertThat(calculator.input("1111 / -2")).isEqualTo(-555)
        assertThat(calculator.input("-1111 / -2")).isEqualTo(555)
    }
}
