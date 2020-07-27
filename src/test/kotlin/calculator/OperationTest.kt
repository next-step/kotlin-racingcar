package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperationTest {

    @Test
    fun add() {
        val add = Operation.of("+")!!
        assertThat(add(6.0, 6.0)).isEqualTo(12.0)
    }

    @Test
    fun sub() {
        val sub = Operation.of("-")!!
        assertThat(sub(6.0, 6.0)).isEqualTo(0.0)
    }

    @Test
    fun multi() {
        val multi = Operation.of("*")!!
        assertThat(multi(6.0, 6.0)).isEqualTo(36.0)
    }

    @Test
    fun div() {
        val div = Operation.of("/")!!
        assertThat(div(6.0, 1.0)).isEqualTo(6.0)
        assertThat(Double.NaN.equals(div(1.0, 0.0))).isTrue()
    }

    @Test
    fun `undefined operator`() {
        assertThat(Operation.of("5")).isNull()
    }
}
