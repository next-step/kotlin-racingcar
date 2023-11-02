package racingCarWinner

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCarWinner.domain.AlwaysMoveStrategy
import racingCarWinner.domain.AlwaysNotMoveStrategy
import racingCarWinner.domain.Car
import racingCarWinner.domain.RandomMoveStrategy

class RacingGameTest {
    @Test
    fun `자동차 경주 우승자가 1명 이상인지 확인한다`() {
        // given
        val racingGame = RacingGame.of(
            carNames = carNames,
            strategy = RandomMoveStrategy,
            numOfAttempts = NUM_OF_ATTEMPTS
        )

        // when
        val winners = racingGame.start()

        // then
        assertTrue(winners.isNotEmpty())
    }

    @Test
    fun `모든 자동차가 movable할 때 numOfAttempts번의 경주에서 모두 전진했다`() {
        val racingGame = RacingGame.of(
            carNames = carNames,
            strategy = AlwaysMoveStrategy,
            numOfAttempts = NUM_OF_ATTEMPTS
        )

        // when
        val racingCars = racingGame.start()

        // then
        racingCars.forEach {
            assertTrue(it.location == NUM_OF_ATTEMPTS)
        }
    }

    @Test
    fun `모든 자동차가 movable하지 않을 때 numOfAttempts번의 경주에서 모두 멈춰있다`() {
        // given
        val racingGame = RacingGame.of(
            carNames = carNames,
            strategy = AlwaysNotMoveStrategy,
            numOfAttempts = NUM_OF_ATTEMPTS
        )

        // when
        val racingCars = racingGame.start()

        // then
        racingCars.forEach {
            assertTrue(it.location == 0)
        }
    }

    companion object {
        private const val NUM_OF_ATTEMPTS = 5
        private val carNames = listOf("pobi1", "pobi2", "pobi3")
    }
}