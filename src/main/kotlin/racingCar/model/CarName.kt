package racingCar.model

data class CarName(val name: String) {
    init {
        isValid(name)
    }

    private fun isValid(name: String) {
        require(name.length <= LIMIT_NAME_LENGTH) { throw IllegalArgumentException(CAR_NAME_INPUT_WARNING) }
    }

    companion object {
        private const val LIMIT_NAME_LENGTH = 5
        private const val CAR_NAME_INPUT_WARNING = "자동차 이름은 $LIMIT_NAME_LENGTH 자를 초과할 수 없습니다."
    }
}
