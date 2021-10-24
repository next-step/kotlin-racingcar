package racingcar.domain

data class Record(val name: Name, val score: Int)  {

    constructor(car: RacingCar) : this(car.name, car.position.value)
}
