package racingcar.domain

class RacingGame(
    carNames: List<String>,
    val attemptSize: Int
) {
    val cars = List(carNames.size) { Car(carNames[it]) }
        get() = field.toList()
    var curAttemptNum: Int = 0
        private set
    private val _history: MutableList<List<Car>> = mutableListOf()
    val history: List<List<Car>>
        get() = _history
    var winners: List<Car>? = null
        private set

    fun attempt(conditions: List<Int>) {
        check(curAttemptNum < attemptSize) { "시도 횟수를 초과했습니다." }

        cars.forEachIndexed { index, car ->
            car.move(conditions[index])
        }
        _history.add(cars.map { it.copy() })
        curAttemptNum++

        if (curAttemptNum == attemptSize) {
            val winnerPosition = cars.map { it.position }.max()
            winners = cars.filter { it.position == winnerPosition }
        }
    }

    companion object {
        const val MAX_CONDITION: Int = 10
    }
}
