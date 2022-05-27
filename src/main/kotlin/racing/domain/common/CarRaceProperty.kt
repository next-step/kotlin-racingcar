package racing.domain.common

import racing.domain.car.Car

class CarRaceProperty(val roundSize: Int) {
    lateinit var cars: List<Car>

    constructor(roundSize: Int, carNames: List<String>) : this(roundSize) {
        cars = carNames.map { Car(it) }
    }

    companion object {
        const val ROUND_START = 1
    }
}
