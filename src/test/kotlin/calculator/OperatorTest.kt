package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {

    @Test
    fun `덧셈 기호로 ADD를 찾을 수 있다`() {
        assertThat(Operator.findByValue("+")).isEqualTo(Operator.ADD)
    }

    @Test
    fun `뺄셈 기호로 SUBTRACT를 찾을 수 있다`() {
        assertThat(Operator.findByValue("-")).isEqualTo(Operator.SUBTRACT)
    }

    @Test
    fun `곱셈 기호로 MULTIPLY를 찾을 수 있다`() {
        assertThat(Operator.findByValue("*")).isEqualTo(Operator.MULTIPLY)
    }

    @Test
    fun `나눗셈 기호로 DIVIDE를 찾을 수 있다`() {
        assertThat(Operator.findByValue("/")).isEqualTo(Operator.DIVIDE)
    }
}
