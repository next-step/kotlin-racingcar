package racingcar.domain

class Car(private var position: Int = 0, val name: String) {

    init {
        require(name.length in NAME_LENGTH_RANGE)
    }

    fun move(condition: Int): CarHistory {
        if (condition in MOVE_CONDITION_RANGE) {
            position++
        }
        return CarHistory(position)
    }

    companion object {
        val NAME_LENGTH_RANGE = 1..5
        val MOVE_CONDITION_RANGE = 4..9
    }
}

class CarHistory(var position: Int)
