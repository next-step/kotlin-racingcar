package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    fun `덧셈 테스트`() {
        val cal = Operator.PLUS.cal(1, 2)
        assertThat(cal).isEqualTo(3);
    }
}
