import game.randomnumbergenerator.RealRandomNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun 랜덤_숫자_생성() {
        // Given
        val randomNumberGenerator = RealRandomNumberGenerator()

        // When
        val randomNumber = randomNumberGenerator.generate()

        // Then
        assertThat(randomNumber).isBetween(RealRandomNumberGenerator.from, RealRandomNumberGenerator.to)
    }
}
