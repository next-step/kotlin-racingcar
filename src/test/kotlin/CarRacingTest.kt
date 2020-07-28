import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `test for null and empty`() {
        assertThatThrownBy { CarRacingView.checkInput("") }.isInstanceOf(NullPointerException::class.java)
        assertThatThrownBy { CarRacingView.checkInput(null) }.isInstanceOf(NullPointerException::class.java)
    }

    @Test
    fun `test isNumber`() {
        assertThatThrownBy { CarRacingView.checkInput("r") }.isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `test for is more than 1`() {
        assertThatThrownBy { CarRacingView.checkInput("-1") }.isInstanceOf(ArithmeticException::class.java)
    }

    @Test
    fun `test for count of movement`() {
        assertTrue(CarRacing.countOfMovement(4) <= 4)
    }
}
