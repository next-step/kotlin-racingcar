package racingcar

class Car(position: Int = DEFAULT_POSITION) {
    var position = position
        private set

    fun move(condition: Int) {
        if (condition >= 4) {
            position++
        }
    }

    companion object {
        const val DEFAULT_POSITION = 1
    }
}
