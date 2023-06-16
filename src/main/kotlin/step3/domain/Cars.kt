package step3.domain

class Cars(
    values: List<Car> = emptyList()
) {
    var values = values
        private set

    fun add(car: Car) {
        values = values + Car(name = car.name, position = car.position)
    }
}
