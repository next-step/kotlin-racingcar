package race.model

data class Car(
    private val _name: String,
    private var _position: Int = START_POSITION
) {

    init {
        require(name.length < MAXIMUM_NAME_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }

    val name: String get() = _name
    val position: Int get() = _position

    fun move(count: Int): Car = if (count >= MOVE_CONDITION) {
        Car(_name = name, _position = position + 1)
    } else {
        this
    }

    companion object {
        const val START_POSITION = 0
        const val MOVE_CONDITION = 4
        const val MAXIMUM_NAME_LENGTH = 5
    }
}
