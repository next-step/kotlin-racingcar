package racingcar.domain

private const val MIN_CARS_SIZE = 2

class RacingGame(
    private var cars: List<Car>,
    private val tryNumber: TryNumber,
) {
    init {
        require(cars.size >= MIN_CARS_SIZE) { "자동차 경주 게임에는 최소 2대 이상의 자동차가 필요합니다. cars size = ${cars.size}" }
    }

    fun play(movementStrategy: () -> Int): List<List<Car>> {
        val result = mutableListOf<List<Car>>()
        while (tryNumber.isPlaying) {
            cars = cars.map { it.moveOrNot(movementStrategy.invoke()) }
                .also { result.add(it) }
            tryNumber.consume()
        }

        return result.toList()
    }
}
