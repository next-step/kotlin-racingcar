package racingcar.domain

import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>,
) {

    fun race(): List<RacingSituation> {
        return cars.map { car: Car ->
            car.move(random.nextInt(RANDOM_MAX_VALUE))
            RacingSituation(Car(car.name, car.position))
        }
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default

        fun of(carNames: List<String>): RacingGame {
            val cars = carNames.map {
                Car(it)
            }

            return RacingGame(cars)
        }
    }
}
