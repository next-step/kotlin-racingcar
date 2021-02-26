package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionTest {
    @Test
    fun `식을 빈칸을 기준으로 나눠 계산한다`() {
        // given
        val expression = Expression("1 + 2")

        // when
        val result = expression.calculate()

        // then
        assertThat(result).isEqualTo(3)
    }
}
