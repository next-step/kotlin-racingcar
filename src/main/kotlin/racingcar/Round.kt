package racingcar

class Round {
    var result = listOf<Car>()
        private set

    fun saveResult(carList: List<Car>) {
        result = carList.map {
            it.copy(it.distance)
        }
    }
}
