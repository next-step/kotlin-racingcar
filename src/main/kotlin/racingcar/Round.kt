package racingcar

class Round {
    private var result = listOf<Car>()
    private val DISTANCE_LETTER = "-"

    fun saveResult(carList: List<Car>) {
        result = carList.map { it.copy() }
    }

    fun getResult(): List<String> {
        return result.map {
            DISTANCE_LETTER.repeat(it.distance)
        }
    }
}
