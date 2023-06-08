package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class PlusOperationTest {
    @Test
    fun `더하기 테스트`() {
        // given
        val plusOperation = PlusOperation(NumberOperation("11"), NumberOperation("10"))

        // when
        val result = plusOperation.operate()

        // then
        Assertions.assertThat(result).isEqualTo(BigDecimal(21))
    }
}
