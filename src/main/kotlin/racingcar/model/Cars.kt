package racingcar.model

class Cars(val value: List<Car>) {
    fun move(random: () -> MoveFactor) {
        value.forEach { car -> car.move(random()) }
    }

    fun carsInLead(): Cars {
        val winnerPosition = value.maxOf { car -> car.position.value }
        return Cars(value.filter { car -> car.position.value == winnerPosition })
    }
}
