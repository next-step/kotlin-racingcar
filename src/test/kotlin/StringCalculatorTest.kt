import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `blank string test`() {
        assertThatThrownBy { StringCalculator.calculate("            ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Empty value. Please input a expression. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `one string number test`() {
        val actual = StringCalculator.calculate("3")
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun valueTest1() {
        val result = StringCalculator.calculate("1 + 2 * 3 / 3")
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun valueTest2() {
        val result = StringCalculator.calculate("3 / 9 + 2 - 3 * 2")
        assertThat(result).isEqualTo(-2)
    }

    @Test
    fun `even list`() {
        assertThatThrownBy { StringCalculator.calculate("1 + 2 + 3 4") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `first string is not a number`() {
        assertThatThrownBy { StringCalculator.calculate("a1 + 2 + 3 + 4") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `last string is not a number`() {
        assertThatThrownBy { StringCalculator.calculate("1 + 2 + 3 + 4+") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `devided by zero`() {
        assertThatThrownBy { StringCalculator.calculate("1 + 2 / 0 + 1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `can not calculate`() {
        assertThatThrownBy { StringCalculator.calculate("1+2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `invalid operator`() {
        assertThatThrownBy { StringCalculator.calculate("1 ^ 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid operator")
    }
}
