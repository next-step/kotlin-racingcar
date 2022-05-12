package car.racing

class Cars(driverNames: List<String>) {
    private val cars = List(driverNames.size) { index -> Car(driverNames[index]) }

    fun getAllRecord(): List<Record> = cars.map { it.getRecord() }

    private fun Car.getRecord(): Record = Record(driverName, moves)

    fun runAll(): Unit = cars.forEach(Car::run)
}
