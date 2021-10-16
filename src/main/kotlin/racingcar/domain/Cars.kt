package racingcar.domain

class Cars(private val numberGenerator: NumberGenerator, cars: List<Car>) {
    private val cars = cars

    constructor(carNames: List<String>, numberGenerator: NumberGenerator) : this(
        numberGenerator,
        carNames.map { Car(it) })

    fun move() {
        cars.forEach { it.move(numberGenerator.getNumber()) }
    }

    fun exportWinners(): List<String> {
        return cars.sortedByDescending { it.position }
            .groupBy { it.position }
            .values.first()
            .map { it.name }
    }

    fun exportResult(): Map<String, Int> {
        return cars.associateBy({ it.name }, { it.position })
    }
}
