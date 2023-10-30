package racingcar.model

data class Car(val name: String, private var _position: Int = 0) {
    val position: Int get() = _position
    init {
        require(name.length <= CAR_NAME_MAX_BOUND) { CAR_NAME_VALIDATION_MESSAGE }
    }

    fun stepForward(move: Boolean) {
        if (move) _position++
    }

    companion object {
        private const val CAR_NAME_VALIDATION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
        private const val CAR_NAME_MAX_BOUND = 5
    }
}
