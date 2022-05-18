package car.domain

class Cars(driverNames: List<String>) {
    private val cars = List(driverNames.size) { index -> Car(driverNames[index]) }

    fun getAllRecord(): List<Record> = cars.map { it.getRecord() }

    fun runAll(): Unit = cars.forEach(Car::run)
}
