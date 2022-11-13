import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `문자열 계산기 테스트`() {
        val person = Calculator()
        assertThat(person.main("2 + 3 * 4 / 2")).isEqualTo(10.0)
    }
}
