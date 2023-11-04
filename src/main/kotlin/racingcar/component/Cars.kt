package racingcar.component

import racingcar.model.Car
import kotlin.random.Random

class Cars(
    private val cars: List<Car>
) {
    fun getCars(): List<Car> {
        return cars
    }

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxBy {
            it.getDistance()
        }

        return cars.filter {
            it.getDistance() == winnerCar.getDistance()
        }
    }

    fun moveCars(condition: () -> Boolean = DEFAULT_MOVEMENT_CONDITION) {
        cars.filter { condition() }
            .forEach {
                it.move()
            }
    }

    companion object {
        val DEFAULT_MOVEMENT_CONDITION = { Random.nextInt(0, 10) >= 4 }

        fun create(carNames: List<String>): Cars {
            val cars = carNames.map {
                Car(it)
            }

            return Cars(cars)
        }
    }
}
