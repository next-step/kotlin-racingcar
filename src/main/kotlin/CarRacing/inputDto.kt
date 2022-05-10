package CarRacing

import java.lang.Integer.parseInt

class inputDto(carCountString: String, movementTryCountString: String) {
    val carCount: Int
    val movementTryCount: Int

    init {
        validateForIntegerString(carCountString, "자동차 대수")
        validateForIntegerString(movementTryCountString, "시도할 횟수")

        carCount = parseInt(removeSpace(carCountString))
        movementTryCount = parseInt(removeSpace(movementTryCountString))
    }

    companion object {
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