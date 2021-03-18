package racingcar.domain

data class Car(val name: String) {

    init {
        require(name.length <= 5)
    }

    private val _history = mutableListOf<CarAction>()
    val history
        get() = _history.toList()

    fun move() {
        _history.add(CarAction.MOVE)
    }

    fun stop() {
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
}
