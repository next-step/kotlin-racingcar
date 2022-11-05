package calculator.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CalculationBlockTest {

    @Test
    fun `연산이 없을 경우 apply 불가`() {
        val block = CalculationBlock(BigDecimal(10))
        val decimal = BigDecimal(10)
        assertThatThrownBy { block.apply(decimal) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `중간 연산일 경우 result 획득 불가`() {
        val block = CalculationBlock(BigDecimal(10), Calculation.ADD)
        assertThatThrownBy { block.result() }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `숫자_연산자 Reduce`() {
        val block = CalculationBlock(BigDecimal(10))
        val value = "+"
        val expected = CalculationBlock(BigDecimal(10), Calculation.of("+"))

        val result = CalculationBlock.reduce(block, value)

        assertThat(result.accumulator).isEqualTo(expected.accumulator)
        assertThat(result.calculation).isEqualTo(expected.calculation)
    }

    @Test
    fun `숫자_연산자_숫자 Reduce`() {
        val block = CalculationBlock(BigDecimal(10), Calculation.ADD)
        val value = "11"
        val expected = CalculationBlock(BigDecimal(21))

        val result = CalculationBlock.reduce(block, value)

        assertThat(result.accumulator).isEqualTo(expected.accumulator)
        assertThat(result.calculation).isEqualTo(expected.calculation)
    }

    @Test
    fun `연산자가 없을 경우 reduce 불가`() {
        val block = CalculationBlock(BigDecimal(10))
        val value = "10"
        assertThatThrownBy { CalculationBlock.reduce(block, value) }
            .isInstanceOf(IllegalStateException::class.java)
    }
}
