package racingcar

data class Cars(private val cars: List<Car>) {
    var positions = Positions()
        private set

    constructor(names: Array<Name>) : this(names.map { Car(NamedPosition.Smart(it)) })
    constructor(cars: Int) : this((0 until cars).map { Name(it) }.toTypedArray())

    fun drive() {
        positions = cars.map { it.driving() }
            .fold(Positions(), Positions::append)
    }
}
