package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalTest {

    @Test
    fun `toDouble return infinity`() {
        val value: BigDecimal = BigDecimal.valueOf(Double.MAX_VALUE)
        val result = value.add(value)
        result.toDouble().shouldBe(Double.POSITIVE_INFINITY)
    }

    @Test
    fun `toDouble returns MAX VALUE`() {
        val value: BigDecimal = BigDecimal.valueOf(Double.MAX_VALUE)
        val result = value.add(BigDecimal.valueOf(10))
        result.toDouble().shouldBe(Double.MAX_VALUE)
    }

    @Test
    fun setScale() {
        val value: BigDecimal = BigDecimal.valueOf(10.000001)
        val result = value.setScale(0, RoundingMode.FLOOR)
        result.toInt().shouldBe(10)
    }

    @Test
    fun `divide by zero`() {
        assertThatThrownBy { BigDecimal.ONE.divide(BigDecimal.ZERO) }
            .isExactlyInstanceOf(ArithmeticException::class.java)
    }
}
