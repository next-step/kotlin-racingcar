package car.racing

class Cars(driverNames: List<String>) {
    private val cars = mutableListOf<Car>().apply {
        driverNames.forEach { name ->
            add(Car(name))
        }
    }

    fun getAllMoves(): List<Int> = cars.map { it.moves }
    fun runAll(): Unit = cars.forEach(Car::run)
}
