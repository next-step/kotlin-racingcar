package racingcar.domain

class Car(private var position: Int = 0, val name: String) {

    init {
        require(name.length in NAME_LENGTH_RANGE) { "자동차의 이름은 1~5자 이내여야 합니다." }
    }

    fun prepare(): CarHistory {
        position++
        return CarHistory(name, position)
    }

    fun move(condition: Int): CarHistory {
        if (condition in MOVE_CONDITION_RANGE) {
            position++
        }
        return CarHistory(name, position)
    }

    companion object {
        val NAME_LENGTH_RANGE = 1..5
        val MOVE_CONDITION_RANGE = 4..9
    }
}

class CarHistory(val name: String, var position: Int)
