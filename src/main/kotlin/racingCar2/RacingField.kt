package racingCar2

class RacingField(
    private val cars: List<Car>,
) {
    constructor(vararg carNames: String) : this(cars = List(carNames.size) { Car(carNames[it]) })

    val carNames: List<String> get() = cars.map { it.name }
}
