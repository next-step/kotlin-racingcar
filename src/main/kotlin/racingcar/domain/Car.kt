package racingcar.domain

class Car(val name: String = "Anonymous") {
    var position = DEFAULT_POSITION
        private set

    fun move(number: Int) {
        if (number >= FORWARD_NUMBER) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
    }
}
