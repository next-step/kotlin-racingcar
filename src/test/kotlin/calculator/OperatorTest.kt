package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperatorTest {

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
