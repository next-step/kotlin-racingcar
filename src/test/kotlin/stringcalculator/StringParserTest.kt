package stringcalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class StringParserTest {
    @Test
    fun testValidInput() {
        val input = "10+5-3*2/4"
        val parser = StringParser(input)

        val numbers = parser.numbers()
        val operators = parser.operators()

        Assertions.assertThat(numbers).containsExactly(10, 5, 3, 2, 4)
        Assertions.assertThat(operators).containsExactly("+", "-", "*", "/")
    }

    @Test
    fun `input 값이 비어있는 경우 IllegalArgumentException 발생`() {
        assertThatIllegalArgumentException()
            .isThrownBy { StringParser("") }
    }

    @Test
    fun `연산자가 없는 경우 IllegalArgumentException 발생`() {
        val input = "10 5 3 2 4"
        assertThatIllegalArgumentException()
            .isThrownBy { StringParser(input) }
    }

    @Test
    fun `연산자의 숫자가 숫자들의 수 보다 하나만큼 적지 않은 경우 IllegalArgumentException 발생`() {
        val input = "10+5-3*2/4+"
        assertThatIllegalArgumentException()
            .isThrownBy { StringParser(input) }
    }

    @Test
    fun `숫자 변환이 실패할 경우 IllegalArgumentException 발생`() {
        val input = "t+2+a"
        assertThatIllegalArgumentException()
            .isThrownBy { StringParser(input) }
    }
}