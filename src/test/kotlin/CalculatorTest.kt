import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `해인테스트`() {
        val person = Calculator()
        assertThat(person.main()).hasSize(3)
    }
}
