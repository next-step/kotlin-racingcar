package racing.domain.common

import racing.domain.car.Car

class CarRaceProperty(val roundSize: Int) {
    lateinit var cars: List<Car>
        private set

    constructor(roundSize: Int, carNames: List<String>) : this(roundSize) {
        cars = carNames.map { Car(it) }
    }
}
