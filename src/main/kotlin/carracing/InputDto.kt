package carracing

data class InputDto(val carNamesString: String, val movementTryCountString: String) {
    val carNames: List<String>
    val movementTryCount: Int

    init {
        validateForIntegerString(movementTryCountString, MOVEMENT_TRY_COUNT_NAME)
        validateForCarNames(carNamesString)

        carNames = carNamesString.split(",")
        movementTryCount = removeSpace(movementTryCountString).toInt()
    }

    companion object {
        private const val MOVEMENT_TRY_COUNT_NAME = "시도할 횟수"
        private val ONLY_NUMBER_REGEX = Regex("(\\d)+")
        private const val ERROR_MESSAGE_CAR_STRING_SPACE = "자동차 이름은 공백이 올수 없습니다"
        private const val ERROR_MESSAGE_CAR_STRING_5_LETTER = "자동차 이름은 5글자를 초과할수 없습니다"

        private fun removeSpace(spaceContainedString: String): String {
            return spaceContainedString.replace("\\s".toRegex(), "")
        }

        fun validateForIntegerString(numberString: String, parameterName: String) {
            if (!ONLY_NUMBER_REGEX.matches(removeSpace(numberString))) {
                val errorMessage = ErrorMessage.getErrorMessageForOnlyIntegerString(
                    parameterName, numberString
                )
                throw IllegalArgumentException(errorMessage)
            }
        }

        fun validateForCarNames(carNamesString: String) {
            carNamesString.split(",").forEach { validateForCarName(it) }
        }

        private fun validateForCarName(carName: String) {
            if (carName.trim().isEmpty()) throw IllegalArgumentException(ERROR_MESSAGE_CAR_STRING_SPACE)
            if (carName.length > 5) throw IllegalArgumentException(ERROR_MESSAGE_CAR_STRING_5_LETTER)
        }
    }
}
