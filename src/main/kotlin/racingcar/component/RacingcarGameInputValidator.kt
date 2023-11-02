package racingcar.component

object RacingcarGameInputValidator {
    fun validateCarNamesString(carNamesString: String?): String {
        require(carNamesString != null) {
            "자동차 이름은 null이거나 공백일 수 없습니다."
        }

        return carNamesString
    }

    fun validateCarName(carName: String): String {
        require(carName.isNotBlank() && carName.length <= 5) {
            "자동차 이름은 공백이거나 5자를 초과할 수 없습니다."
        }

        return carName
    }

    fun validateRoundNumberString(roundNumberString: String?): Int {
        require(!roundNumberString.isNullOrBlank()) {
            "시도 횟수는 null 또는 공백일 수 없습니다."
        }

        val roundNumber = roundNumberString.toInt()

        require(roundNumber > 0) {
            "시도 횟수는 자연수만 가능합니다."
        }

        return roundNumber
    }
}
