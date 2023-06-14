package racingCar2

class Car(
    private val _name: String,
) {
    private var _position: Int = DEFAULT_POSITION
    val name: String get() = _name
    val position: Int get() = _position

    init {
        check(name.length < MAX_NAME_LENGTH) { "자동차의 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(number: Int) {
        if (number > FORWARD_CONDITIONS)
            _position++
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val FORWARD_CONDITIONS = 4
        const val DEFAULT_POSITION = 0
    }
}
