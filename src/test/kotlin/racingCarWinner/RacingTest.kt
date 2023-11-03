package racingCarWinner

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCarWinner.domain.Car
import racingCarWinner.domain.RacingGame
import racingCarWinner.domain.strategy.AlwaysMoveStrategy
import racingCarWinner.domain.strategy.AlwaysNotMoveStrategy

class RacingTest {
    @Test
    fun `주어진 횟수(numOfAttempts)만큼 경주를 진행할 경우 1명 이상의 우승자가 정상적으로 선정되는지 확인한다`() {
        // given
        val numOfAttempts = 5
        val racingCars = listOf(
            Car.of("winner1", AlwaysMoveStrategy),
            Car.of("winner2", AlwaysMoveStrategy),
            Car.of("loser", AlwaysNotMoveStrategy),
        )
        val racingGame = RacingGame.of(
            cars = racingCars
        )

        // when
        val winners = Racing.of(racingGame).start(numOfAttempts = numOfAttempts)

        // then
        assertTrue(winners.isNotEmpty())
        Assertions.assertIterableEquals(
            listOf("winner1", "winner2"),
            winners
        )
    }
}