package game.racing.domain

class Car(var position: Int = MIN_POSITION) {

    fun moveOrStayBySpeed(speed: Int) {
        if (speed >= MIN_MOVE_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
        const val MIN_POSITION = 0
        const val MIN_MOVE_THRESHOLD = 4
    }
}
