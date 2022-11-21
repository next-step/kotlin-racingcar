package car_race.logic.car

class CarNames private constructor (val names: List<CarName>) {
    constructor(input: String) : this(input.split(",").map { CarName(it) })
}
