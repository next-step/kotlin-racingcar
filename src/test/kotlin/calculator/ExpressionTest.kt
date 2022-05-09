package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionTest {

    @Test
    fun `계산하기`() {
        val value = "2 + 3 * 4 / 2".split(" ")
        val toList = value.toList()

        val expression = Expression(toList)
        val result = expression.calculate()

        assertThat(result).isEqualTo(10)
    }
}
