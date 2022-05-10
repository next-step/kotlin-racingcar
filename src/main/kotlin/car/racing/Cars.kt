package car.racing

class Cars(drivers: Int) {
    private val cars = List(size = drivers) { Car() }

    fun getAllMoves(): List<Int> = cars.map { it.moves }
    fun runAll(): Unit = cars.forEach(Car::run)
}
