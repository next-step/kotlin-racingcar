package step3

data class Cars(private val cars: List<Car>) {
    constructor(cars: Int) : this((0 until cars).map { Car() })

    var positions = Positions()

    fun drive() {
        positions = cars.map { it.driving() }
            .fold(Positions(), Positions::plus)
    }
}
