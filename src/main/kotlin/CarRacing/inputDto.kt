package CarRacing

class inputDto(carCount: String?, movementTryCount: String?) {

    companion object {
        val ONLY_NUMBER_REGEX = Regex("([0-9])+")

        private fun removeSpace(spaceContainedString: String): String {
            return spaceContainedString.replace("\\s".toRegex(), "")
        }

        fun validateForIntegerString(numberString: String, parameterName: String) {
            if(!ONLY_NUMBER_REGEX.matches(numberString)) {
                throw IllegalArgumentException(ErrorMessage.getErrorMessageForOnlyIntegerString(parameterName, numberString))
            }
        }

    }
}