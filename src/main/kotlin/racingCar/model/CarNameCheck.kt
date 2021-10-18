package racingCar.model

class CarNameCheck {
    companion object {
        fun isValid(name : String) {
            if(name.length > LIMIT_NAME_LENGTH) {
                throw IllegalArgumentException(CAR_NAME_INPUT_WARNING)
            }
        }
        private const val LIMIT_NAME_LENGTH = 5
        private const val CAR_NAME_INPUT_WARNING = "자동차 이름은 $LIMIT_NAME_LENGTH 자를 초과할 수 없습니다."
    }
}