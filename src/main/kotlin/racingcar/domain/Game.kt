package racingcar.domain

class Game(
    val rule: Rule
) {

    private val _carPositions: MutableList<Int> = MutableList(rule.carSize) { 0 }
    val carPositions: List<Int> = _carPositions

    private val _history: MutableList<MutableList<Int>> = mutableListOf()
    val history: List<List<Int>> = _history

    private var curAttemptNum: Int = 0

    fun attemptToMove(vararg movingCars: Int) {
        check(curAttemptNum < rule.attemptSize)

        _history.add(
            if (curAttemptNum == 0) MutableList(rule.carSize) { 0 } else _history[curAttemptNum - 1].toMutableList()
        )

        for (carIdx in 0 until rule.carSize) {
            if (rule.moveOrNot?.invoke() == true || movingCars.contains(carIdx)) {
                _carPositions[carIdx]++
                _history[curAttemptNum][carIdx]++
            }
        }
        curAttemptNum++
    }
}
