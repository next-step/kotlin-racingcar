package racingcar.domain

class Cars(private val carNumber: Int, private val numberGenerator: NumberGenerator) {
    private val cars = List(carNumber) { Car() }

    fun move() {
        cars.forEach { it.move(numberGenerator.getNumber()) }
    }

    fun exportPositions(): List<Int> {
        return cars.map { it.position }
    }
}
