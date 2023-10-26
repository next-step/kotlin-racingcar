package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorCalculatorStateTest {

    @Test
    fun `숫자 입력시 숫자가 잘 들어간다`() {
        val result = OperatorCalculatorState(1)

        assertThat(result.result()).isEqualTo(1)
    }
}
