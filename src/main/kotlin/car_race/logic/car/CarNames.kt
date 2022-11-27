package car_race.logic.car

data class CarNames(val names: List<CarName>) {
    constructor(input: String) : this(input.split(",").map(::CarName))
}
