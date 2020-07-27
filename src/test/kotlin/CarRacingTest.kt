import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `test for input`() {
        assertThatThrownBy { CarRacing.execute("", "3") }.isInstanceOf(NullPointerException::class.java)
        assertThatThrownBy { CarRacing.execute(null, "1") }.isInstanceOf(NullPointerException::class.java)
    }
}
