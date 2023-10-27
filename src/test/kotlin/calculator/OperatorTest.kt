package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class OperatorTest {
    @Test
    fun `덧셈`() {
        assertThat(Operator.PLUS.operate(1, 2)).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        assertThat(Operator.MINUS.operate(1, 2)).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        assertThat(Operator.MULTIPLY.operate(3, 4)).isEqualTo(12)
    }

    @Test
    fun `나눗셈`() {
        assertThat(Operator.DIVIDE.operate(4, 2)).isEqualTo(2)
    }

    @Test
    fun `연산자 매핑`() {
        assertAll(
            { assertThat(Operator.from('+')).isEqualTo(Operator.PLUS) },
            { assertThat(Operator.from('-')).isEqualTo(Operator.MINUS) },
            { assertThat(Operator.from('*')).isEqualTo(Operator.MULTIPLY) },
            { assertThat(Operator.from('/')).isEqualTo(Operator.DIVIDE) },
            { assertThat(Operator.from('!')).isNull() },
        )
    }
}
