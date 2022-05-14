package car_racing

data class InputDto(val carCountString: String, val movementTryCountString: String) {
    private val _carCount: UInt
    val carCount: Int
        get() = _carCount.toInt()
    val _movementTryCount: UInt
    val movementTryCount: Int
        get() = _movementTryCount.toInt()

    init {
        validateForIntegerString(carCountString, CAR_COUNT_NAME)
        validateForIntegerString(movementTryCountString, MOVEMENT_TRY_COUNT_NAME)

        _carCount = removeSpace(carCountString).toUInt()
        _movementTryCount = removeSpace(movementTryCountString).toUInt()
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
