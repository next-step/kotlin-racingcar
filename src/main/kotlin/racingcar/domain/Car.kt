package racingcar.domain

class Car(private var position: Int = 0) {
    fun move(condition: Int): CarHistory {
        if (condition in MOVE_CONDITION_RANGE) {
            position++
        }
        return CarHistory(position)
    }

    companion object {
        val MOVE_CONDITION_RANGE = 4..9
    }
}

class CarHistory(var position: Int)
