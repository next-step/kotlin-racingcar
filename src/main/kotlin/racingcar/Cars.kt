package racingcar

data class Cars(private val cars: Map<Name, Car>) {
    var positions = Positions()
        private set

    constructor(cars: Int) : this((0 until cars).map { Name(it) to Car() }.toMap())
    constructor(names: List<Name>) : this(names.map { it to Car() }.toMap())

    fun drive() {
        positions = cars.map { (name, car) -> NamedPosition.Smart(name, car.driving().intValue()) }
            .fold(Positions(), Positions::append)
    }
}
