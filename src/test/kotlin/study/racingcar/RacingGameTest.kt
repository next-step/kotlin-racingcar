package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setupRacingGame() {
        racingGame = RacingGame(RandomMoveCarStrategy())
    }

    @Test
    fun `게임 준비가 완료되었는지 확인`() {
        assertThat(racingGame.readyGame(3)).isEqualTo(true)
    }

    @Test
    fun `차를 움직이도록 요청한다`() {
        val car = Car()
        val oldDistance = car.distance
        racingGame.moveCarOrNot(car, true)
        assertThat(car.distance).isNotEqualTo(oldDistance)
    }

    @Test
    fun `차를 움직이지 않도록 한다`() {
        val car = Car()
        val oldDistance = car.distance
        racingGame.moveCarOrNot(car, false)
        assertThat(car.distance).isEqualTo(oldDistance)
    }
}
