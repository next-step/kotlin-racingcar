import RacingGame.getWinner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingGameTest {

    var cars = mutableListOf<Car>()

    @BeforeEach
    fun setUp() {
        cars.addAll(listOf(Car("자동차1"), Car("자동차2"), Car("자동차3")))
    }

    @Test
    fun `random하게 선택된 숫자에 따라 적절히 move 혹은 stop 하는가`() {
        val numberOfTries = 3
        var strategy = object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        }

        repeat(numberOfTries) {
            RacingGame.play(cars, strategy)
        }
        assertThat(cars.first().getMoved()).isEqualTo(numberOfTries)
    }

    @Test
    fun `복수의 승자를 허용하는가`() {
        val numberOfTries = 3
        var strategy = object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        }

        repeat(numberOfTries) {
            RacingGame.play(cars, strategy)
        }
        assertThat(getWinner(cars)).isEqualTo(setOf("자동차1", "자동차2", "자동차3"))
    }
}
