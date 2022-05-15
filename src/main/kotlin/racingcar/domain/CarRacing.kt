package racingcar.domain

import racingcar.util.RandomUtil.randomNumber

object CarRacing {
    fun initCars(carNames: List<String>): List<Car> {
        return carNames.map { carName -> Car(0, carName) }
    }

    fun moveCars(listCar: List<Car>): List<Car> {
        return listCar.map { car ->
            val movedPositon = car.move(randomNumber())
            Car(movedPositon, car.name)
        }
    }

    fun getWinners(cars: List<Car>): List<String> {
        val sortedCar = cars.sortedByDescending { it.position }
        val winnerPosition = sortedCar.first().position
        return sortedCar.filter { it.position == winnerPosition }.map { it.name }
    }
}
