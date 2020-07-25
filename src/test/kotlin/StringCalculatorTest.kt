import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    // TODO.04 test case 최소화하기 (case는 최소화하면서 모든 경우의 수를 테스트하기)
    @Test
    fun `add`() {
        val result1 = StringCalculator().calculate("3 + 4")
        val result2 = StringCalculator().calculate("10 + 7 + 3")
        assertThat(result1).isEqualTo(7)
        assertThat(result2).isEqualTo(20)
    }

    @Test
    fun `subtract`() {
        val result1 = StringCalculator().calculate("3 - 4")
        val result2 = StringCalculator().calculate("10 - 7 - 3")
        assertThat(result1).isEqualTo(-1)
        assertThat(result2).isEqualTo(0)
    }

    @Test
    fun `multiply`() {
        val result1 = StringCalculator().calculate("3 * 4")
        val result2 = StringCalculator().calculate("10 * 7 * 3")
        assertThat(result1).isEqualTo(12)
        assertThat(result2).isEqualTo(210)
    }

    @Test
    fun `divide`() {
        val result1 = StringCalculator().calculate("0 / 2")
        val result2 = StringCalculator().calculate("100 / 10 / 2")
        assertThat(result1).isEqualTo(0)
        assertThat(result2).isEqualTo(5)
    }

    @Test
    fun `useAllOperators`() {
        val result1 = StringCalculator().calculate("3 + 4 - 2 * 10 / 10")
        val result2 = StringCalculator().calculate("3 + 3 - 2")
        assertThat(result1).isEqualTo(5)
        assertThat(result2).isEqualTo(4)
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
