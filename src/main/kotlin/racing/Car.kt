package racing

data class Car(val name: String, private var _position: Int = 0) {

    init {
        validateCar()
    }

    val position
        get() = _position

    fun move() {
        _position++
    }

    private fun validateCar() {
        validateNameLength(name)
        validateEmpty(name)
    }

    private fun validateNameLength(carName: String) {
        require(carName.length > 5) { ERR_MSG_INVALID_NAME_LENGTH_MESSAGE }
    }

    private fun validateEmpty(carName: String) {
        // 공백을 입력했을 경우
        require(carName.isBlank()) { ERR_MSG_INVALID_EMPTY_NAME_MESSAGE }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Car) return false

        return this.name == other.name && this._position == other._position
    }

    override fun hashCode(): Int {
        return name.hashCode() + _position
    }

    companion object {
        private const val ERR_MSG_INVALID_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
        private const val ERR_MSG_INVALID_EMPTY_NAME_MESSAGE = "자동차 이름이 공백입니다."
    }
}
