package racingcar.domain

class RacingGame(
    val carSize: Int,
    val attemptSize: Int
) {
    private val cars = List(carSize) { Car() }
    var curAttemptNum: Int = 0
        private set
    private val _history: MutableList<List<Int>> = mutableListOf()
    val history: List<List<Int>>
        get() = _history

    fun attempt(conditions: List<Int>) {
        check(curAttemptNum < attemptSize) { "시도 횟수를 초과했습니다." }

        cars.forEachIndexed { index, car ->
            car.move(conditions[index])
        }
        _history.add(cars.map { it.position })
        curAttemptNum++
    }

    companion object {
        const val MAX_CONDITION: Int = 10
    }
}
