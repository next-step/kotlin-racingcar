package racingcar.domain.vo

enum class CarAction {
    MOVE,
    STAND,
    ;

    fun isMove(): Boolean {
        return this == MOVE
    }

    companion object {
        private val VALID_NUMBER_RANGE = 0..9

        fun generate(number: Int): CarAction {
            checkInvalidNumber(number)
            if (number >= 4) {
                return MOVE
            }
            return STAND
        }

        private fun checkInvalidNumber(value: Int) {
            require(value in VALID_NUMBER_RANGE) { "생성되는 숫자는 0에서 9 사이의 값이어야 합니다." }
        }
    }
}
