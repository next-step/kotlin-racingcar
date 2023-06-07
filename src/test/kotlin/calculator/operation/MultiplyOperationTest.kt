package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MultiplyOperationTest {
    @Test
    fun `곱하기 테스트`() {
        // given
        val operation = MultiplyOperation(NumberOperation("11"), NumberOperation("10"))

        // when
        val result = operation.operate()

        // then
        Assertions.assertThat(result).isEqualTo(BigDecimal(110))
    }
}
