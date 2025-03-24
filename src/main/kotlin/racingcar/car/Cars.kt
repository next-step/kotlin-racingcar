package racingcar.car

class Cars(
    val values: List<Car>,
) {
    val positions: List<Int>
        get() = values.map { it.position }

    fun moveAll() = values.forEach(Car::move)

    fun winningCarNames(): List<String> {
        val maxPosition = values.maxOf { it.position }
        return values.filter { it.position == maxPosition }
            .map { it.name }
    }

    companion object {
        fun fromNames(carNames: List<String>) =
            Cars(
                carNames.map { Car(it) },
            )
    }
}
