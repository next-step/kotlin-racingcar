package study.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {
    @Test
    fun findBySymbol() {
        assertThat(Operator.findBySymbol("+")).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `findBySymbol if non-valid symbol`() {
        assertThat(Operator.findBySymbol("$")).isNull()
    }
}
