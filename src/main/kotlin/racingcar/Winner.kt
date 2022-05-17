package racingcar

class Winner(cars: List<Car>) {

    val winners: List<String>

    init {
        val maxPosition = cars.maxOf { it.position }
        winners = cars.filter { it.isWinner(maxPosition) }
            .map { it.name }
    }
}
