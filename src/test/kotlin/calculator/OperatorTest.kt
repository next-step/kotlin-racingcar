package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class OperatorTest {

    @Test
    fun plus() {
        assertThat(Operator.PLUS.operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(8))
        assertThat(Operator.of("+").operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(8))
    }

    @Test
    fun minus() {
        assertThat(Operator.MINUS.operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(2))
        assertThat(Operator.of("-").operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(2))
    }

    @Test
    fun multiply() {
        assertThat(Operator.MULTIPLY.operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(15))
        assertThat(Operator.of("*").operate(BigDecimal(5), BigDecimal(3))).isEqualTo(BigDecimal(15))
    }

    @Test
    fun divide() {
        assertThat(Operator.DIVIDE.operate(BigDecimal(6), BigDecimal(3))).isEqualTo(BigDecimal(2))
        assertThat(Operator.of("/").operate(BigDecimal(6), BigDecimal(3))).isEqualTo(BigDecimal(2))
    }

    @Test
    fun `0으로 나누면, IllegalArgumentException`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Operator.DIVIDE.operate(BigDecimal(6), BigDecimal(0)) }
    }

    @Test
    fun `지원하지 않는 연산자 문자이면, IllegalArgumentException`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Operator.of("=").operate(BigDecimal(6), BigDecimal(0)) }
    }
}
