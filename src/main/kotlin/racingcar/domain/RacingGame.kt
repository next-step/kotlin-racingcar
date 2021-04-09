package racingcar.domain

class RacingGame(
    private val round: Int,
    private var cars: Cars
) {

    init {
        require(round > 0) { "시도할 횟수는 0보다 커야한다. round: $round" }
    }

    fun race(): RacingResult {
        val carsRange = (cars.elements.indices)

        val resultElements = mutableListOf<Cars>()
        repeat(round) {
            val moveStrategies = carsRange.map { RandomMoveStrategy() }
            cars = cars.move(moveStrategies)
            resultElements.add(cars)
        }

        return RacingResult(resultElements)
    }
}
