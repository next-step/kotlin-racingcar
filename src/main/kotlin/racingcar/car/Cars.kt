package racingcar.car

class Cars(
    private val values: List<Car>,
) {
    fun moveAll() = values.forEach(Car::move)

    fun getPositions() = values.map { it.position }
}
