package carRacing

import java.lang.Integer.parseInt

class inputDto(carCountString: String, movementTryCountString: String) {
    val carCount: Int
    val movementTryCount: Int

    init {
        validateForIntegerString(carCountString, CAR_COUNT_NAME)
        validateForIntegerString(movementTryCountString, MOVEMENT_TRY_COUNT_NAME)

        carCount = parseInt(removeSpace(carCountString))
        movementTryCount = parseInt(removeSpace(movementTryCountString))
    }

    companion object {
        private const val CAR_COUNT_NAME = "자동차 대수"
        private const val MOVEMENT_TRY_COUNT_NAME = "시도할 횟수"
        private val ONLY_NUMBER_REGEX = Regex("([0-9])+")

        private fun removeSpace(spaceContainedString: String): String {
            return spaceContainedString.replace("\\s".toRegex(), "")
        }

        fun validateForIntegerString(numberString: String, parameterName: String) {
            if(!ONLY_NUMBER_REGEX.matches(removeSpace(numberString))) {
                throw IllegalArgumentException(ErrorMessage.getErrorMessageForOnlyIntegerString(parameterName, numberString))
            }
        }

    }
}