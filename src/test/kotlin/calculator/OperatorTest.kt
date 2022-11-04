package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {

    @Test
    fun plus() {
        assertThat(Operator.PLUS.operate(5, 3)).isEqualTo(8)
        assertThat(Operator.of("+").operate(5, 3)).isEqualTo(8)
    }

    @Test
    fun minus() {
        assertThat(Operator.MINUS.operate(5, 3)).isEqualTo(2)
        assertThat(Operator.of("-").operate(5, 3)).isEqualTo(2)
    }

    @Test
    fun multiply() {
        assertThat(Operator.MULTIPLY.operate(5, 3)).isEqualTo(15)
        assertThat(Operator.of("*").operate(5, 3)).isEqualTo(15)
    }

    @Test
    fun divide() {
        assertThat(Operator.DIVIDE.operate(6, 3)).isEqualTo(2)
        assertThat(Operator.of("/").operate(6, 3)).isEqualTo(2)
    }

    @Test
    fun `0으로 나누면, IllegalArgumentException`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Operator.DIVIDE.operate(6, 0) }
    }

    @Test
    fun `지원하지 않는 연산자 문자이면, IllegalArgumentException`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Operator.of("=").operate(6, 0) }
    }
}
