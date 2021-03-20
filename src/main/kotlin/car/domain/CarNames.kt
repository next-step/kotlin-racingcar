package car.domain

class CarNames(private val names: List<CarName>) : List<CarName> by names {
    constructor(names: Array<String>) : this(names.map(::CarName))
}
