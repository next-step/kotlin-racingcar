package racingcar.domain

private const val MIN_CARS_SIZE = 2

class Cars(
    private val cars: List<Car>,
) {
    val value: List<Car>
        get() = cars.toList()

    init {
        require(cars.size >= MIN_CARS_SIZE) { "자동차 경주 게임에는 최소 2대 이상의 자동차가 필요합니다. cars size = ${cars.size}" }
    }

    fun moveAll(movementStrategy: () -> Int): Cars {
        val nextCars = cars.map { it.moveOrNot(movementStrategy.invoke()) }
        return Cars(nextCars)
    }
}
