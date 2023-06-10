package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.car.MockEngine

class RacingGameTest {
    @Test
    fun `게임 한 라운드가 진행`() {
        // given
        val engine1 = MockEngine(2)
        val engine2 = MockEngine(4)
        val engine3 = MockEngine(10)
        val cars = listOf(Car("car1", engine1), Car("car2", engine2), Car("car3", engine3))

        val game = RacingGame(cars)

        // when
        game.startRound()

        // then
        assertThat(cars).extracting({ it.distance })
            .containsExactly(tuple(0), tuple(1), tuple(1))
    }
}
