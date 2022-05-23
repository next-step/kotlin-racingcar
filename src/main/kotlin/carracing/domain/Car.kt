package carracing.domain

class Car(val name: String, carDistance: Int = 0) {
    var distance: Int = carDistance
        private set

    fun move(moveDistance: Int) {
        distance += moveDistance
    }

    init {
        validate()
    }

    @Throws(IllegalArgumentException::class)
    fun validate() {
        validateForCarName(name)
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val ERROR_MESSAGE_CAR_STRING_SPACE = "자동차 이름은 공백이 올수 없습니다"
        private const val ERROR_MESSAGE_CAR_STRING_5_LETTER = "자동차 이름은 ${MAX_CAR_NAME_LENGTH}글자를 초과할수 없습니다"

        fun validateForCarName(carName: String) {
            require(carName.trim().isNotEmpty()) { ERROR_MESSAGE_CAR_STRING_SPACE }
            require(carName.length <= MAX_CAR_NAME_LENGTH) { ERROR_MESSAGE_CAR_STRING_5_LETTER }
        }
    }
}
