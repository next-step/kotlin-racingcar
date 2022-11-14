package study.racingcar.racing

import study.racingcar.car.Car

data class Result(val name: String, val location: Int) {
    constructor(car: Car) : this(car.name, car.currentLocation)
}
