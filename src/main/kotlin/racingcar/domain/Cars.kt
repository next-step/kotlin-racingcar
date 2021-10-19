package racingcar.domain

import racingcar.service.CarMoveForwardDecider

class Cars private constructor(private val racingCars: List<Car>) {
    companion object {
        fun from(carNames: CarNames): Cars {
            val racingCars = carNames
                .getCarNames()
                .map { name -> Car(name) }
                .toList()

            return Cars(racingCars)
        }
    }

    fun moveForward(carMoveForwardDecider: CarMoveForwardDecider) {
        this.racingCars
            .forEach { car -> car.moveForward(carMoveForwardDecider) }
    }

    fun getCars(): List<Car> {
        return this.racingCars.toList()
    }

    fun getCar(index: Int): Car {
        if (index < 0 || index >= racingCars.size) {
            throw ArrayIndexOutOfBoundsException()
        }

        return this.getCars()[index]
    }

    fun getWinners(): List<Car> {
        val maximumPosition = this.racingCars
            .map { it.position }
            .maxOrNull() ?: 0

        val (winners, _) = racingCars.partition { it.position == maximumPosition }
        return winners
    }
}
