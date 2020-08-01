package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `getOperatorType test`() {
        assertThat(Operator.valueOf("+").operation(4.0, 5.0)).isEqualTo(9.0)
        assertThat(Operator.valueOf("-").operation(4.0, 5.0)).isEqualTo(-1.0)
        assertThat(Operator.valueOf("*").operation(4.0, 5.0)).isEqualTo(20.0)
        assertThat(Operator.valueOf("/").operation(4.0, 5.0)).isEqualTo(0.8)
    }
}
