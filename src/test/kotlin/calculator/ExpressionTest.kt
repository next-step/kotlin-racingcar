package calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpressionTest {

    @Test
    fun `수식을 계산하기 쉽게 문자 Queue로 반환한다`() {
        val expression = Expression("2 * 3 / 3 + 1")
        val queue = expression.compute()
        assertThat(queue.size).isEqualTo(7)
    }

    @Test
    fun `잘못된 수식을 문자 Queue로 반환한다`() {
        assertThrows<IllegalArgumentException> {
            Expression("2 * 3 / 3 ! 1")
        }
    }
}
