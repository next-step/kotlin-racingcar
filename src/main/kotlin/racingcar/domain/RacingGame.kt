package racingcar.domain

import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>,
) {

    fun race(): List<RacingSituation> {
        return cars.map { car: Car ->
            car.move(random.nextInt(RANDOM_MAX_VALUE))
            RacingSituation(car.carName, car.currentPosition)
        }
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default
    }
}
