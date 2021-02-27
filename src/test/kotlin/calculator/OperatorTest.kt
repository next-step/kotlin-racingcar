package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {
    @Test
    fun `plus`() {
        assertThat(Operator.PLUS.operator).isEqualTo("+")
    }

    @Test
    fun `minus`() {
        assertThat(Operator.MINUS.operator).isEqualTo("-")
    }

    @Test
    fun `multiply`() {
        assertThat(Operator.MULTIPLY.operator).isEqualTo("*")
    }

    @Test
    fun `division`() {
        assertThat(Operator.DIVISION.operator).isEqualTo("/")
    }
}
