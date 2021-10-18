package racingcar.domain

import racingcar.service.CarMoveForwardDecider

class Cars(carNames: CarNames) {
    private var racingCars: List<Car> = ArrayList()

    init {
        racingCars = carNames
            .getCarNames()
            .map { name -> Car(name) }
            .toList()
    }

    fun moveForward(carMoveForwardDecider: CarMoveForwardDecider) {
        racingCars
            .forEach { car -> car.moveForward(carMoveForwardDecider) }
    }

    fun getCars(): List<Car> {
        return this.racingCars
    }

    fun getCar(index: Int): Car {
        if (index < 0 || index >= racingCars.size) {
            throw ArrayIndexOutOfBoundsException()
        }

        return this.racingCars[index]
    }

    fun getWinners(): List<Car> {
        val maximumPosition = this.racingCars
            .map { it.position }
            .maxOrNull() ?: 0

        val (winners, _) = racingCars.partition { it.position == maximumPosition }
        return winners
    }
}
