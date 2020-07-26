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
    fun `use all operators`() {
        assertThat(StringCalculator().calculate("3 + 4 - 2 * 10 / 10")).isEqualTo(5)
    }

    @Test
    fun `is null or empty`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringCalculator().calculate("") }
            .withMessage("값을 입력해주세요.")
    }

    @Test
    fun `is not correct operator`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringCalculator().calculate("2 # 3 + 4") }
            .withMessage("올바르지 않은 연산자 #이(가) 있습니다.")
    }

    @Test
    fun `is divided by zero`() {
        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy { StringCalculator().calculate("2 / 0") }
            .withMessage("0으로 나눌 수 없습니다.")
    }
}
