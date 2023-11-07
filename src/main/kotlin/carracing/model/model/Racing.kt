package carracing.model.model

class Racing(
    numberOfCar: Int,
    private val rule: Rule = Rule.RandomRule()
) {
    val cars: List<Car> = List(numberOfCar) { Car() }

    fun progress() {
        cars.forEach { it.move(rule) }
    }

    fun takeSnapshot(): Snapshot = cars.map { it.moveCountInRacing }
}
