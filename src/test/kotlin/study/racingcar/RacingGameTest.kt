package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import study.racingcar.domain.Car
import study.racingcar.domain.RacingGame
import study.racingcar.domain.RandomMoveCarStrategy

internal class RacingGameTest {

    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setupRacingGame() {
        racingGame = RacingGame(RandomMoveCarStrategy())
    }

    @Test
    fun `차를 움직이도록 요청한다`() {
        val car = Car("test")
        val oldDistance = car.distance
        racingGame.moveCarOrNot(car, true)
        assertThat(car.distance).isNotEqualTo(oldDistance)
    }

    @Test
    fun `차를 움직이지 않도록 한다`() {
        val car = Car("test")
        val oldDistance = car.distance
        racingGame.moveCarOrNot(car, false)
        assertThat(car.distance).isEqualTo(oldDistance)
    }
}
