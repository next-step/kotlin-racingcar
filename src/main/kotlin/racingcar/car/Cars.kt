package racingcar.car

class Cars(
    val values: List<Car>,
) {
    fun moveAll() = values.forEach(Car::move)

    fun winningCarNames(): List<String> {
        val maxPositionedCar =
            values.reduce { current, value ->
                current.takeIf {
                    it.hasHigherPositionThan(value)
                } ?: value
            }

        return values.filter { it.hasSamePositionTo(maxPositionedCar) }
            .map { it.name }
    }

    companion object {
        fun fromNames(carNames: List<String>) =
            Cars(
                carNames.map { Car(it) },
            )
    }
}
