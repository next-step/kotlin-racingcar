package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class DivideTest {

    private val one = object : Expression {
        override fun evaluate(): Double = 1.0
    }

    private val zero = object : Expression {
        override fun evaluate(): Double = 0.0
    }

    @Test
    fun `0으로 나눌 수 없다`() {
        assertThatThrownBy {
            Divide.evaluate(one, zero)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("나누는 값은 0이 될 수 없습니다")
    }
}
