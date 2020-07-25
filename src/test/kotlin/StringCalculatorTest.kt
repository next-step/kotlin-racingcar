import StringCalculator.*
import StringCalculator.Companion.add
import StringCalculator.Companion.calculate
import StringCalculator.Companion.divide
import StringCalculator.Companion.multiply
import StringCalculator.Companion.operation
import StringCalculator.Companion.subtraction
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `입력 값이 null 또는 빈 문자열`() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        assertThat(operation(first = 1, operator = add, second = 2)).isEqualTo(3)
        assertThat(operation(first = 1, operator = subtraction, second = 2)).isEqualTo(-1)
        assertThat(operation(first = 1, operator = multiply, second = 2)).isEqualTo(2)
        assertThat(operation(first = 1, operator = divide, second = 2)).isEqualTo(1/2)
    }

    @Test
    fun `연산`() {
        assertThat(calculate("1 + 2 + 3 + 4 + 5")).isEqualTo(15)
        assertThat(calculate("1 + 2 * 3 / 3 - 1")).isEqualTo(2)
        assertThat(calculate("2 / 2 / 1 + 4 * 5")).isEqualTo(25)
    }
}