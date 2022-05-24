package carracing.service.dto

import carracing.domain.Car
import carracing.util.ErrorMessage

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
        private const val CAR_NAMES_STRING_DELIMITERS = ","

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
            carNamesString.split(CAR_NAMES_STRING_DELIMITERS).forEach { Car.validateForCarName(it) }
        }
    }
}
