package study.calculator

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class OperationsTest {
    @Test
    fun `test addition`() {
        assertThat(Operations.add(2.toDouble(), 3.toDouble())).isEqualTo(5.toDouble())
    }

    @Test
    fun `test subtraction`() {
        assertThat(Operations.subtract(2.toDouble(), 3.toDouble())).isEqualTo((-1).toDouble())
    }

    @Test
    fun `test multiplication`() {
        assertThat(Operations.multiply(2.toDouble(), 3.toDouble())).isEqualTo(6.toDouble())
    }

    @Test
    fun `test division`() {
        assertThat(Operations.divide(4.toDouble(), 2.toDouble())).isEqualTo(2.toDouble())
    }
}
