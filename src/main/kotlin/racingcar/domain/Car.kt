package racingcar.domain

class Car(var position: Int = DEFAULT_POSITION) {
    fun move(number: Int): Int {
        if (number >= 4) position++

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}
