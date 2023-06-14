package racingCar2

class RacingField(
    private val cars: List<Car>,
    private val _gameCount: Int,
) {
    constructor(carNames: Array<String>, gameCount: Int) : this(List(carNames.size) { Car(carNames[it]) }, gameCount)

    val carNames: List<String> get() = cars.map { it.name }
    val gameCount: Int get() = _gameCount
}
