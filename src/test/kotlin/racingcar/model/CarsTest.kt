package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.strategy.MoveStrategy

internal class CarsTest {
    @Test
    fun makeCars() {
        // when
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)

        // then
        assertThat(cars.getNumberOfCars()).isEqualTo(carNames.size)
    }

    @Test
    fun findMaxScore() {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(75, cars)

        // when
        val winners = cars.findMaxScore()

        // then
        assertThat(winners).isEqualTo(38)
    }

    @Test
    fun findWinners() {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(50, cars)

        // when
        val winners: List<Car> = cars.findWinners()

        // then
        assertThat(winners.size).isEqualTo(3)
        assertThat(winners[0].score).isEqualTo(25)
    }

    private fun runGames(gameCount: Int, cars: Cars) {
        for (i in 1..gameCount step 2) {
            cars.moveOnce(GoMoveStrategy)
        }

        for (i in 2..gameCount step 2) {
            cars.moveOnce(StayMoveStrategy)
        }
    }
}

private object GoMoveStrategy : MoveStrategy {
    override fun canMove() = true
}

private object StayMoveStrategy : MoveStrategy {
    override fun canMove() = false
}
