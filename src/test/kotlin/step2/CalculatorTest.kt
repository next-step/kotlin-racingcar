package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `정상 테스트`() {
        val calculator = Calculator()
        val result = calculator.calculate("4 * 10 + 5 + 20 / 2 + 7 - 3")

        assertThat(result).isEqualTo(36)
    }

    @Test
    fun `비정상 테스트`() {
        val calculator = Calculator()
        assertThatIllegalArgumentException().isThrownBy { calculator.calculate("4 * 10 + 5 + 20 / 2 + 7 - 3 *") }
    }
}
