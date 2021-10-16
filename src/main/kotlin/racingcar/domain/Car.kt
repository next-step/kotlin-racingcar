package racingcar.domain

class Car(val name: String = "anony", position: Int = DEFAULT_POSITION) {
    var position = position
        private set

    init {
        require(!name.isNullOrBlank())
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.")
        }
    }

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
