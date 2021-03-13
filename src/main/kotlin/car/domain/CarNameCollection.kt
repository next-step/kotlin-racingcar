package car.domain

class CarNameCollection(val names: List<CarName>) {
    constructor(names: Array<String>) : this(names.map { CarName(it) })
}
