package racingcar.domain

import racingcar.service.CarMoveForwardDecider

class Cars private constructor(private val racingCars: List<Car>) {
    fun moveForward(carMoveForwardDecider: CarMoveForwardDecider) {
        this.racingCars
            .forEach { car -> car.moveForward(carMoveForwardDecider) }
    }

    fun getCars(): List<Car> {
        return this.racingCars.toList()
    }

    operator fun get(index: Int): Car = racingCars[index]

    fun getWinners(): List<Car> {
        val maximumPosition = this.racingCars
            .map { it.position }
            .maxOrNull() ?: 0

        val (winners, _) = racingCars.partition { it.position == maximumPosition }
        return winners
    }

    companion object {
        fun from(carNames: CarNames): Cars {
            val racingCars = carNames
                .getCarNames()
                .map { name -> Car(name) }
                .toList()

            return Cars(racingCars)
        }
    }
}
