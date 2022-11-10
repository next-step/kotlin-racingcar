import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

class CalculatorTest {

    @Test
    fun `2 더하기 3은 5이다`() {
        val calculator = Calculator()
        val result = calculator.calculate("2 + 3")
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `7 빼기 6은 1이다`() {
        val calculator = Calculator()
        val result = calculator.calculate("7 - 6")
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `5 곱하기 3은 15이다`() {
        val calculator = Calculator()
        val result = calculator.calculate("5 * 3")
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `20 나누기 4는 5이다`() {
        val calculator = Calculator()
        val result = calculator.calculate("20 / 4")
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `입력값이 null 이거나 빈 공백 문자 일 경우 IAE`() {
        val calculator = Calculator()
        val exception = assertThrows<IllegalArgumentException> { calculator.calculate(null) }

        assert(exception.message == "계산식이 NULL 혹은 공백입니다.")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IAE`() {
        val calculator = Calculator()
        val exception = assertThrows<IllegalArgumentException> { calculator.calculate("7 ! 3") }

        assertThat(exception.message).isEqualTo("사칙연산 기호가 아닙니다.")
    }

    @Test
    fun `4 더하기 8 빼기 6 곱하기 3 나누기 3 은 3이다`() {
        val calculator = Calculator()
        val result = calculator.calculate("4 + 8 - 6 * 3 / 6")

        assertThat(result).isEqualTo(3)
    }
}
