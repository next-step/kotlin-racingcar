package racingcar.model

class Cars(val value: List<Car>) : List<Car> by value {
    fun move(random: () -> MoveFactor) {
        this.forEach { car -> car.move(random()) }
    }

    fun carsInLead(): Cars {
        val winnerPosition = this.maxOf { car -> car.position.value }
        return Cars(this.filter { car -> car.position.value == winnerPosition })
    }
}
