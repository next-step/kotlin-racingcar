package racingcar

class Winner(cars: List<Car>) {

    private var _winner: List<String>

    init {
        val maxPosition = cars.maxOf { it.position }
        _winner = cars.filter { it.isWinner(maxPosition) }
            .map { it.name }
    }

    val winners: List<String>
        get() = _winner
}
