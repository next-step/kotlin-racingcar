package racingcar.domain

class Car(private val name: Name, position: Int = DEFAULT_POSITION) {
    var position = position
        private set

    fun move(number: Int) {
        if (number >= FORWARD_NUMBER) {
            position++
        }
    }

    fun getName(): String {
        return name.name
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_NUMBER = 4
    }
}
