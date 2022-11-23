package racingcar.model

class Cars(val value: List<Car>) {
    val size = value.size

    fun move(random: () -> MoveFactor) {
        value.forEach { car -> car.move(random()) }
    }

    fun carsInLead(): Cars {
        val winnerPosition = value.maxOf { car -> car.position.value }
        return Cars(value.filter { car -> car.position.value == winnerPosition })
    }

    fun forEach(action: (Car) -> Unit) {
        value.forEach(action)
    }

    fun <R> map(transform: (Car) -> R): List<R> {
        return value.map(transform)
    }

    fun first(): Car {
        return value.first()
    }

    fun toTypedArray(): Array<Car> {
        return value.toTypedArray()
    }
}
