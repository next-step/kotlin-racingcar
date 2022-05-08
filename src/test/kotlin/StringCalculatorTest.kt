import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @Test
    fun `null이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            val stringCalculator = StringCalculator(null)
            stringCalculator.execute()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `빈 문자열이 입력될 경우 IllegalArgumentException 에러가 발생한다`() {
        assertThatThrownBy {
            val stringCalculator = StringCalculator("")
            stringCalculator.execute()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "2//", "2++", "2 + 3     / 4"])
    fun `비 정상적인 수식이 들어올 경우 IllegalArgumentException 에러가 발생한다`(input: String?) {
        assertThatThrownBy {
            val stringCalculator = StringCalculator(input)
            stringCalculator.execute()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}