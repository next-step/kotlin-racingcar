package racingcar.domain

class Car {

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

    fun currentHistory(index: Int): CarAction {
        return _history[index]
    }
}
