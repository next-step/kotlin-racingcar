package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberTest {

    @Test
    fun `4칙_연산_테스트`() {
        val number1 = Number(1.0)
        val number2 = Number(2.0)

        assertThat(number1 + number2).isEqualTo(Number(3.0))
        assertThat(number1 - number2).isEqualTo(Number(-1.0))
        assertThat(number1 / number2).isEqualTo(Number(0.5))
        assertThat(number1 * number2).isEqualTo(Number(2.0))
    }
}
