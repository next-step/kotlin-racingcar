package racingcar.domain

import racingcar.domain.exception.CarNameLengthException

class Car(var name: String, var position: Int = DEFAULT_POSITION) {
    init {
        require(name.length <= 5) { throw CarNameLengthException() }
    }

    fun move(number: Int): Int {
        if (number >= 4) position++

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}
