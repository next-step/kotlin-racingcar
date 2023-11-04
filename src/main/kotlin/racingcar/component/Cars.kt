package racingcar.component

import racingcar.model.Car

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

    companion object {
        fun create(carNames: List<String>): Cars {
            val cars = carNames.map {
                Car(it)
            }

            return Cars(cars)
        }
    }
}
