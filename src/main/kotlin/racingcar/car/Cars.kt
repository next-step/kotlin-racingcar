package racingcar.car

class Cars(
    private val values: List<Car>,
) {
    val names: List<String>
        get() = values.map { it.name.value }

    val positions: List<Int>
        get() = values.map { it.position }

    fun moveAll() = values.forEach(Car::move)

    companion object {
        fun fromNames(carNames: List<String>) =
            Cars(
                carNames.map { Car(it) },
            )
    }
}
