package racingcar.domain

import io.kotest.matchers.collections.shouldContainExactly
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

    @Test
    fun `자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다`() {
        // given
        val winner = Name("win")
        val winningMovement = Movement(1)
        val losingMovement = Movement(0)

        // when
        val carRacer = MockCarRacer(0)
        val racingGame = RacingGame(
            listOf(
                RacingCar(winner, winningMovement, carRacer),
                RacingCar(Name("lose1"), losingMovement, carRacer),
                RacingCar(Name("lose2"), losingMovement, carRacer)
            )
        )

        // then
        racingGame.getWinners() shouldContainExactly listOf(winner.value)
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        // given
        val winner1 = Name("win1")
        val winner2 = Name("win2")
        val winningMovement = Movement(1)
        val losingMovement = Movement(0)

        // when
        val carRacer = MockCarRacer(0)
        val racingGame = RacingGame(
            listOf(
                RacingCar(winner1, winningMovement, carRacer),
                RacingCar(winner2, winningMovement, carRacer),
                RacingCar(Name("lose"), losingMovement, carRacer)
            )
        )

        // then
        racingGame.getWinners() shouldContainExactly listOf(winner1.value, winner2.value)
    }
}
