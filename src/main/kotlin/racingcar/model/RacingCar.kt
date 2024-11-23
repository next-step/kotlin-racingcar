package racingcar.model

class RacingCar(val carName: String, var position: Int = 0) {
    init {
        require(carName.matches(TYPE_AND_SIZE.toRegex())) { CAR_NAME_ERROR_MESSAGE }
    }

    fun race(forwardCondition: () -> Boolean) {
        if (forwardCondition()) {
            position += 1
        }
    }

    companion object {
        private const val TYPE_AND_SIZE = "^[a-z]{1,5}$"
        private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하의 소문자만 가능합니다."

        fun from(carName: String): RacingCar {
            return RacingCar(carName.trim())
        }
    }
}
