package racingcar.component

import racingcar.model.Car

class Cars {
    fun getWinners(cars: List<Car>): List<Car> {
        val winnerCar = cars.maxBy {
            it.getDistance()
        }

        return cars.filter {
            it.getDistance() == winnerCar.getDistance()
        }
    }
}
