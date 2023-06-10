import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberTest {
    @Test
    fun randomNumberTest() {
        val randomNumber = RandomNumberGenerator.getRandomNumber()
        assertThat(randomNumber).isBetween(0, 9)
    }
}
