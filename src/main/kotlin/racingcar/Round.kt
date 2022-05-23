package racingcar

class Round {
    private val _result = mutableListOf<Car>()
    val result: List<Car> get() = _result.toList()
    fun saveResult(carList: List<Car>) {
        _result.addAll(
            carList.map { it.copy(defaultDistance = it.distance) }
        )

        result.maxOf { it.distance }
    }

    fun winner(): List<Car> {
        val maxDistance = result.maxOf { it.distance }
        return result.filter { it.distance == maxDistance }
    }
}
