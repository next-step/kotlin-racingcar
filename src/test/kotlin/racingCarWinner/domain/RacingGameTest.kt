package racingCarWinner.domain

import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCarWinner.domain.strategy.AlwaysMoveStrategy
import racingCarWinner.domain.strategy.AlwaysNotMoveStrategy

class RacingGameTest {
    @Test
    fun `자동차 경주 진행 시 차가 전진 혹은 멈춰있는지 확인한다`() {
        // given
        val racingCars = listOf(
            Car.of("pobi1", AlwaysMoveStrategy),
            Car.of("pobi2", AlwaysMoveStrategy),
            Car.of("pobi3", AlwaysNotMoveStrategy),
        )
        val racingGame = RacingGame.of(
            cars = racingCars
        )

        // when
        racingGame.racing()

        // then
        assertIterableEquals(
            listOf(1, 1, 0),
            racingCars.map { it.location }
        )
    }

    @Test
    fun `자동차 경주 후 1명 이상의 우승자가 정상적으로 선정되었는지 확인한다`() {
        // given
        val racingCars = listOf(
            Car.of("winner1", AlwaysMoveStrategy),
            Car.of("winner2", AlwaysMoveStrategy),
            Car.of("loser", AlwaysNotMoveStrategy),
        )
        val racingGame = RacingGame.of(
            cars = racingCars
        )

        // when
        racingGame.racing()
        val winners = racingGame.selectWinner()

        // then
        assertTrue(winners.isNotEmpty())
        assertIterableEquals(
            listOf("winner1", "winner2"),
            winners
        )
    }
}