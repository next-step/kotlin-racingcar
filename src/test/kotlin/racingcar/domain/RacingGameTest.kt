package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.domain.carracer.MockCarRacer

internal class RacingGameTest {

    @Test
    fun move() {
        // given
        val expected = listOf(1, 1, 1)
        val carRacer = MockCarRacer(4)
        val racingGame = RacingGame(listOf(RacingCar(carRacer), RacingCar(carRacer), RacingCar(carRacer)))

        // when
        racingGame.move()

        // then
        racingGame.movements shouldBe expected
    }
}
