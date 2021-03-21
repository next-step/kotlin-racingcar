package racingcar.domain

data class Car(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH)
    }

    private val _history = mutableListOf<CarAction>()
    val history: List<CarAction>
        get() = _history

    private fun move() {
        _history.add(CarAction.MOVE)
    }

    private fun stop() {
        _history.add(CarAction.STOP)
    }

    fun moveOrStop(shouldMove: Boolean) {
        if (shouldMove) {
            move()
        } else {
            stop()
        }
    }

    fun currentPosition(attempt: Int): Int {
        return _history.take(attempt).sumBy {
            if (it == CarAction.MOVE) 1 else 0
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
