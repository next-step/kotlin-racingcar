package carracing

data class InputDto(val carCountString: String, val movementTryCountString: String) {
    val carCount: Int
    val movementTryCount: Int

    init {
        validateForIntegerString(carCountString, CAR_COUNT_NAME)
        validateForIntegerString(movementTryCountString, MOVEMENT_TRY_COUNT_NAME)

        carCount = removeSpace(carCountString).toInt()
        movementTryCount = removeSpace(movementTryCountString).toInt()
    }

    companion object {
        private const val CAR_COUNT_NAME = "자동차 대수"
        private const val MOVEMENT_TRY_COUNT_NAME = "시도할 횟수"
        private val ONLY_NUMBER_REGEX = Regex("(\\d)+")

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
    }
}
