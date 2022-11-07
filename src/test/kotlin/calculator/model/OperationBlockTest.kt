package calculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

internal class OperationBlockTest {

    @Test
    fun `연산이 없을 경우 apply 불가`() {
        val block = OperationBlock(BigDecimal(10))
        val decimal = BigDecimal(10)
        assertThrows<IllegalStateException> { block.apply(decimal) }
    }

    @Test
    fun `중간 연산일 경우 result 획득 불가`() {
        val block = OperationBlock(BigDecimal(10), Operation.ADD)
        assertThrows<IllegalStateException> { block.result() }
    }

    @Test
    fun `숫자_연산자 Reduce`() {
        val block = OperationBlock(BigDecimal(10))
        val value = "+"
        val expected = OperationBlock(BigDecimal(10), Operation.of("+"))

        val result = block.reduce(value)

        assertThat(result.accumulator).isEqualTo(expected.accumulator)
        assertThat(result.operation).isEqualTo(expected.operation)
    }

    @Test
    fun `숫자_연산자_숫자 Reduce`() {
        val block = OperationBlock(BigDecimal(10), Operation.ADD)
        val value = "11"
        val expected = OperationBlock(BigDecimal(21))

        val result = block.reduce(value)

        assertThat(result.accumulator).isEqualTo(expected.accumulator)
        assertThat(result.operation).isEqualTo(expected.operation)
    }

    @Test
    fun `연산자가 없을 경우 reduce 불가`() {
        val block = OperationBlock(BigDecimal(10))
        val value = "10"
        assertThrows<IllegalStateException> { block.reduce(value) }
    }
}
