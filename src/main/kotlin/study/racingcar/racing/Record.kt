package study.racingcar.racing

import study.racingcar.car.Car

data class Record(val name: String, val location: Int) {
    constructor(car: Car) : this(car.name, car.currentLocation)
}
