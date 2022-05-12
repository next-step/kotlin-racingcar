import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `random하게 선택된 숫자에 따라 적절히 move 혹은 stop 하는가`() {
        var car1 = Car()
        val cars = listOf(car1)
        val numberOfTries = 3

        val strategy = object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        }

        repeat(numberOfTries) {
            RacingGame.play(cars, strategy)
        }
        assertThat(cars.first().getMoved()).isEqualTo(numberOfTries)
    }
}
