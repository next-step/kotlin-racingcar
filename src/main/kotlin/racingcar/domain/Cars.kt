package racingcar.domain

class Cars(private val numberGenerator: NumberGenerator, private val cars: List<Car>) {

    constructor(carNames: List<String>, numberGenerator: NumberGenerator) : this(
        numberGenerator,
        carNames.map { Car(Name(it)) })

    fun move() {
        cars.forEach { it.move(numberGenerator.getNumber()) }
    }

    fun exportWinners(): List<String> {
        return cars.sortedByDescending { it.position }
            .groupBy { it.position }
            .values.first()
            .map { it.getName() }
    }

    fun exportResult(): Map<String, Int> {
        return cars.associateBy({ it.getName() }, { it.position })
    }
}
