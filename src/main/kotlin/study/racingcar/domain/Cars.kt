package study.racingcar.domain

import study.racingcar.util.RacingCarRandomGenerator

class Cars(racedCars: List<Car>) {
    val racedCars: List<Car> = racedCars.map { Car(it.carName, it.moveCount) }

    fun moveCars() {
        racedCars.forEach { it.move(RacingCarRandomGenerator.random()) }
    }

    override fun toString(): String {
        return racedCars.joinToString("\n")
    }
}
