package racingcar.domain

class RacingCarGame(
    private val cars: Cars,
    private val attemptCount: Int,
    private val onEachRace: (Cars) -> Unit
) {

    constructor(
        carNames: CarNames,
        attemptCount: Int,
        onEachRace: (Cars) -> Unit
    ) : this(
        cars = Cars(carNames.mapToCar()),
        attemptCount = attemptCount,
        onEachRace = onEachRace,
    )

    fun play(): Cars {
        repeat(attemptCount) {
            cars.race()
            onEachRace(cars)
        }
        return cars
    }
}