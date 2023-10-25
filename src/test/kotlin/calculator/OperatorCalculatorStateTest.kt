package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class OperatorCalculatorStateTest {

    @Test
    fun `숫자 입력시 숫자가 잘 들어간다`() {
        val result = OperatorCalculatorState(1)
        assertAll(
            { assertTrue(result is OperatorCalculatorState) },
            { assertThat(result.result()).isEqualTo(1) }
        )
    }
}
