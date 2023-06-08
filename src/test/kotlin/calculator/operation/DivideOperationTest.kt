package calculator.operation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class DivideOperationTest {
    @Test
    fun `0으로 나눌 때 ArithmeticException 발생`() {
        // given
        val divideOperation = DivideOperation(NumberOperation("1"), NumberOperation("0"))

        // when & then
        Assertions.assertThatThrownBy { divideOperation.operate() }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessage("분모가 0 이 될 수 없습니다.")
    }

    @Test
    fun `나누기 테스트`() {
        // given
        val divideOperation = DivideOperation(NumberOperation("4"), NumberOperation("2"))

        // when
        val result = divideOperation.operate()

        // then
        Assertions.assertThat(result).isEqualTo(BigDecimal(2))
    }
}
