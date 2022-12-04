package study.racingcar.domain.racing

import study.racingcar.domain.car.Car

data class Record(val name: String, val location: Int) {
    constructor(car: Car) : this(car.name, car.currentLocation)
}
