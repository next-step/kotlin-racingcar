import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `입력값으로 공백문자가 전달되면 오류가 발생한다`() {
        val calculator = StringCalculator()
        assertThatThrownBy {
            calculator.calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
