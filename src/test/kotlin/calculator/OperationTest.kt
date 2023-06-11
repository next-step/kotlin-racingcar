package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OperationTest {

    @Test
    fun `0으로 나누면 IllegalArgumentException 발생`() {
        Assertions.assertThatThrownBy {
            Operation.DIVIDE.execute(BigDecimal(2), BigDecimal.ZERO)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `나누어 떨어지지 않는 나머지 연산`() {
        Assertions.assertThat(Operation.DIVIDE.execute(BigDecimal(5), BigDecimal(2))).isEqualTo(BigDecimal(2.5))
    }
}
