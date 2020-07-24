import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class StringCalculatorTest {
    @Test
    fun `blank string test`() {
        val result = StringCalculator().calculation("            ")
        assertThat(result).isEqualTo("")
    }

    @Test
    fun `one string number test`() {
        val actual = StringCalculator().calculation("3")
        assertThat(actual).isEqualTo("3")
    }

    @Test
    fun valueTest() {
        val result = StringCalculator().calculation("1 + 2 * 3")
        assertThat(result).isEqualTo("9.0")
    }

    @Test
    fun valueTest2() {
        val result = StringCalculator().calculation("1 + 2 * 3 / 3")
        assertThat(result).isEqualTo("3.0")
    }

    @Test
    fun valueTest3() {
        val result = StringCalculator().calculation("1 + 2")
        assertThat(result).isEqualTo("3.0")
    }

    @Test
    fun valueTest4() {
        val result = StringCalculator().calculation("3 / 9 + 2 - 3 * 2")
        assertThat(result).isEqualTo("-1.333333333333333")
    }

    @Test
    fun valueTest5() {
        val result = StringCalculator().calculation("3 / 9 + 2 - 3 * 2")
        assertThat(result).isEqualTo("-1.333333333333333")
    }

    @Test
    fun `even list test`() {
        assertThatThrownBy { StringCalculator().calculation("1 + 2 + 3 4") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `first string is not number test`() {
        assertThatThrownBy { StringCalculator().calculation("a1 + 2 + 3 + 4") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `last string is not number test`() {
        assertThatThrownBy { StringCalculator().calculation("1 + 2 + 3 + 4+") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `devided by zero test`() {
        assertThatThrownBy { StringCalculator().calculation("1 + 2 / 0 + 1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

    @Test
    fun `can not calculate`() {
        assertThatThrownBy { StringCalculator().calculation("1+2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input. It must use like 1 + 2 * 3 / 4")
    }

}