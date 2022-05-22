package racing

import kotlin.random.Random

object Racing {
    private const val MIN_PIVOT_VALUE = 0
    private const val MAX_PIVOT_VALUE = 10

    fun start(carNames: List<String>, tryRound: Int): List<RacingCar> {
        val racingCars: List<RacingCar> = carNames.map { RacingCar(it) }

        repeat(tryRound) {
            race(racingCars)
        }

        return racingCars
    }

    private fun race(racingCars: List<RacingCar>) {
        for (car in racingCars) {
            car.race(createMovePoint())
        }
    }

    private fun createMovePoint(): Int {
        return Random.nextInt(MIN_PIVOT_VALUE, MAX_PIVOT_VALUE)
    }
}
