package carracing.model.model

class Racing(numberOfCar: Int) {
    val cars: List<Car> = List(numberOfCar) { index -> Car(index) }

    fun progress() {
        cars.forEach { it.move() }
    }

    fun takeSnapshot() = Snapshot(cars.map { it.getTrace() })
}
