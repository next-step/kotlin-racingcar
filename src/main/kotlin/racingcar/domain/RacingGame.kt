package racingcar.domain

class RacingGame(
    private val round: Int,
    private var cars: Cars
) {

    init {
        require(round > 0) { "시도할 횟수는 0보다 커야한다. round: $round" }
    }

    fun race(numberGenerator: RandomNumberGenerator): RacingResult {
        val carsRange = (cars.elements.indices)

        val resultElements = mutableListOf(cars)
        repeat(round) {
            val numbers = carsRange.map { numberGenerator.generate() }
            cars = cars.move(numbers)
            resultElements.add(cars)
        }

        return RacingResult(resultElements)
    }
}
