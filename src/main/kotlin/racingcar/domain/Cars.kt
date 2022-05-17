package racingcar.domain

private const val MIN_CARS_SIZE = 2

class Cars(
    private val _cars: List<Car>,
) {
    val cars: List<Car>
        get() = _cars.toList()

    init {
        require(cars.size >= MIN_CARS_SIZE) { "자동차 경주 게임에는 최소 2대 이상의 자동차가 필요합니다. cars size = ${_cars.size}" }
    }

    fun moveAll(movementStrategy: () -> Int): Cars {
        return cars.map { it.moveOrNot(movementStrategy.invoke()) }
            .run { Cars(this) }
    }

    fun selectWinners(): List<Name> {
        val maxPosition = _cars.maxOf { it.position }
        return _cars.filter { it.position == maxPosition }
            .map { it.name }
            .sortedBy { it.value }
    }
}
