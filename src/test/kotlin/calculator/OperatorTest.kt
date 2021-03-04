package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `contain test`(sign: String) {
        assertThat(Operator.contain(sign)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["&", "%", "$", " ", ""])
    fun `not contain test`(sign: String) {
        assertThat(Operator.contain(sign)).isFalse()
    }

    @Test
    fun `bySign plus test`() {
        assertThat(Operator.bySign("+")).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `bySign minus test`() {
        assertThat(Operator.bySign("-")).isEqualTo(Operator.MINUS)
    }

    @Test
    fun `bySign times test`() {
        assertThat(Operator.bySign("*")).isEqualTo(Operator.TIMES)
    }

    @Test
    fun `bySign divide test`() {
        assertThat(Operator.bySign("/")).isEqualTo(Operator.DIVIDE)
    }

    @Test
    fun `plus apply test`() {
        assertThat(Operator.PLUS.apply(3, 2)).isEqualTo(5)
    }

    @Test
    fun `minus apply test`() {
        assertThat(Operator.MINUS.apply(3, 2)).isEqualTo(1)
    }

    @Test
    fun `times apply test`() {
        assertThat(Operator.TIMES.apply(3, 2)).isEqualTo(6)
    }

    @Test
    fun `divide apply test`() {
        assertThat(Operator.DIVIDE.apply(6, 2)).isEqualTo(3)
    }

    @Test
    fun `bySign percent test`() {
        Assertions.assertThatThrownBy { Operator.bySign("%") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("% is not operator.")
    }
}
