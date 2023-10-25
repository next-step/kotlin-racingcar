package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperandCalculatorStateTest {

    @Test
    fun `숫자 입력시 숫자가 잘 들어간다`() {
        val operandCalculatorState = OperandCalculatorState(0, Operator.PLUS)
        val result = operandCalculatorState.input("1")
        assertAll(
            { assertTrue(result is OperatorCalculatorState) },
            { assertThat(result.result()).isEqualTo(1) }
        )
    }

    @Test
    fun `결과를 반환하면 예외가 발생한다`() {
        val operandCalculatorState = OperandCalculatorState(0, Operator.PLUS)
        assertThrows<IllegalStateException>("수식이 완성되지 않았습니다.") {
            operandCalculatorState.result()
        }
    }
}
