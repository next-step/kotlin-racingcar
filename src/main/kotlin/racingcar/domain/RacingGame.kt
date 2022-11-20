package racingcar.domain

class RacingGame(
    private val cars: List<Car>,
    private val numberGenerator: NumberGenerator,
) {
    fun round(): List<Car> {
        for (car in cars) {
            val randNumber = numberGenerator.rand()
            car.move(randNumber)
        }

        return cars
    }
}
