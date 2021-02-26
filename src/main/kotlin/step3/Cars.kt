package step3

data class Cars(private val cars: List<Car>) {
    var positions = Positions()

    constructor(cars: Int) : this((0 until cars).map { Car() })

    fun drive() {
        positions = cars.map { it.driving() }
            .fold(Positions(), Positions::plus)
    }
}
