package racingcar.domain

import racingcar.dto.RacingResult
import kotlin.random.Random

class RacingGame {

    fun race(car: Car, randomValue: Int): RacingResult {
        car.move(randomValue)
        return RacingResult(car.name, car.position)
    }

    fun race(cars: List<Car>): List<RacingResult> {
        return cars.map {
            it.move(random.nextInt(RANDOM_MAX_VALUE))
            RacingResult(it.name, it.position)
        }
    }

    companion object {
        private const val RANDOM_MAX_VALUE = 10
        private val random = Random.Default
    }
}
