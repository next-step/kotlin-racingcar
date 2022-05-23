package racingcar

class Round {
    private val _result = mutableListOf<Car>()
    val result: List<Car> get() = _result.toList()
    fun saveResult(carList: List<Car>) {
        _result.addAll(
            carList.map { it.copy(defaultDistance = it.distance) }
        )
    }
}
