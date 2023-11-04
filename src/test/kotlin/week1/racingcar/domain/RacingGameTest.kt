package week1.racingcar.domain

import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `한 번의 턴 진행`() {
        val racingGame = RacingGame(cars)
        racingGame.driveOneTurn().forEach {
            assert(it.mileage in 0..1)
        }
    }

    @Test
    fun `우승자 찾기`() {
        val racingGame = RacingGame(cars)
        repeat(10) {
            val carsAfterDriving = racingGame.driveOneTurn()
            carsAfterDriving.maxOfOrNull { it.mileage }?.let { farthestMileage ->
                val leadingCars = carsAfterDriving.filter { it.isSameMileage(farthestMileage) }
                assert(leadingCars.map { it.name }.toSet() == racingGame.getWinners().toSet())
            }
        }
    }

    companion object {
        private val cars = listOf(
            Car("1"),
            Car("2"),
            Car("3"),
            Car("4"),
        )
    }
}