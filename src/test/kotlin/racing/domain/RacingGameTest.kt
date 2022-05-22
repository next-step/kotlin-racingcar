package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.gamerule.MovingStrategy
import racing.domain.RacingGame.getWinner

class RacingGameTest {

    @Test
    fun `자동차 별로 random하게 선택된 숫자에 따라 적절히 움직여야 한다`() {
        val cars = listOf(Car("자동차1"), Car("자동차2"), Car("자동차3"))
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
    fun `복수의 승자를 허용해야 한다`() {
        val cars = listOf(Car("자동차1"), Car("자동차2"), Car("자동차3"))
        val numberOfTries = 3
        var strategy = object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        }

        repeat(numberOfTries) {
            RacingGame.play(cars, strategy)
        }
        assertThat(getWinner(cars)).isEqualTo(listOf("자동차1", "자동차2", "자동차3"))
    }
}
