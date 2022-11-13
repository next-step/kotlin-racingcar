package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperatorTest {

    @Test
    fun `3 더하기 2는 5이다`() {
        assertThat(Operator.ADD.execute(3, 2)).isEqualTo(5)
    }

    @Test
    fun `3 빼기 2는 1이다`() {
        assertThat(Operator.SUBTRACT.execute(3, 2)).isEqualTo(1)
    }

    @Test
    fun `3 곱하기 2는 6이다`() {
        assertThat(Operator.MULTIPLY.execute(3, 2)).isEqualTo(6)
    }

    @Test
    fun `나눗셈 결과 소수점이 있으면 버린다`() {
        assertThat(Operator.DIVIDE.execute(3, 2)).isEqualTo(1)
    }

    @Test
    fun `4 나누기 2는 2이다`() {
        assertThat(Operator.DIVIDE.execute(4, 2)).isEqualTo(2)
    }

    @Test
    fun `0으로 나누면 ArithmeticException 예외가 발생한다`() {
        val assertion = assertThrows<ArithmeticException> {
            Operator.DIVIDE.execute(4, 0)
        }

        assertThat(assertion.message).isEqualTo("/ by zero")
    }

    @Test
    fun `덧셈 기호로 ADD를 얻을 수 있다`() {
        assertThat(Operator.getByValue("+")).isEqualTo(Operator.ADD)
    }

    @Test
    fun `뺄셈 기호로 SUBTRACT를 얻을 수 있다`() {
        assertThat(Operator.getByValue("-")).isEqualTo(Operator.SUBTRACT)
    }

    @Test
    fun `곱셈 기호로 MULTIPLY를 얻을 수 있다`() {
        assertThat(Operator.getByValue("*")).isEqualTo(Operator.MULTIPLY)
    }

    @Test
    fun `나눗셈 기호로 DIVIDE를 얻을 수 있다`() {
        assertThat(Operator.getByValue("/")).isEqualTo(Operator.DIVIDE)
    }

    @Test
    fun `구현되지 않은 기호를 물어보면 IllegalArgumentException을 던진다`() {
        val unimplementedPrime: String = "%"

        val assertion = assertThrows<IllegalArgumentException> {
            Operator.getByValue(unimplementedPrime)
        }

        assertThat(assertion.message).isEqualTo("구현되지 않은 기호입니다.")
    }
}
