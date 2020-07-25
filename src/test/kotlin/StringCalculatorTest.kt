import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `add`() {
        assertThat(StringCalculator().calculate("10 + 7 + 3")).isEqualTo(20)
    }

    @Test
    fun `subtract`() {
        assertThat(StringCalculator().calculate("10 - 7 - 3")).isEqualTo(0)
    }

    @Test
    fun `multiply`() {
        assertThat(StringCalculator().calculate("10 * 7 * 3")).isEqualTo(210)
    }

    @Test
    fun `divide`() {
        assertThat(StringCalculator().calculate("100 / 10 / 2")).isEqualTo(5)
    }

    @Test
    fun `useAllOperators`() {
        assertThat(StringCalculator().calculate("3 + 4 - 2 * 10 / 10")).isEqualTo(5)
    }

    @Test
    fun `isNullOrEmpty`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringCalculator().calculate("") }
            .withMessage("값을 입력해주세요.")
    }

    @Test
    fun `isNotCorrectOperator`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringCalculator().calculate("2 $ 3 + 4") }
            .withMessage("올바르지 않은 연산자가 있습니다.")
    }

    @Test
    fun `isDividedByZero`() {
        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy { StringCalculator().calculate("2 / 0") }
            .withMessage("0으로 나눌 수 없습니다.")
    }
}
