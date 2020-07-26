package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun init() {
        calculator = Calculator()
    }

    @Test
    fun `calculate 정상 테스트`() {
        val result = calculator.calculate("4 * 10 + 5 + 20 / 2 + 7 - 3")

        assertThat(result).isEqualTo(36)
    }

    @DisplayName("calculate 비정상 테스트")
    @Test
    fun `잘못된 포멧의 데이터인 경우 calculate 시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy { calculator.calculate("4 * 10 + 5 + 20 / 2 + 7 - 3 *") }
    }
}
