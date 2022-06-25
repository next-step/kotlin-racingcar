package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.domain.carracer.MockCarRacer

internal class RacingGameTest {

    @Test
    fun `레이싱 카는 이동 요청 시, 4 이상일 경우에만 이동해야 한다`() {
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
