package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MinusOperationTest {
    @Test
    fun `빼기 테스트`() {
        // given
        val operation = MinusOperation(NumberOperation("11"), NumberOperation("10"))

        // when
        val result = operation.operate()

        // then
        Assertions.assertThat(result).isEqualTo(BigDecimal.ONE)
    }
}
