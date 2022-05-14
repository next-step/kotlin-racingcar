package car_racing

class CarMovementRole {
    companion object {
        private const val MIN_FORWARD_NUMBER = 4
        private const val MIN_RANDOM_NUMBER = 1
        private const val MAX_RANDOM_NUMBER = 9

        @Throws(IllegalArgumentException::class)
        fun getMoveDistance(randomNumber: Int): Int {
            validateRandomNumber(randomNumber)
            if (randomNumber >= MIN_FORWARD_NUMBER) {
                return 1
            }
            return 0
        }

        @Throws(IllegalArgumentException::class)
        private fun validateRandomNumber(randomNumber: Int) {
            validateMinNumber(randomNumber)
            validateMaxNumber(randomNumber)
        }

        private fun validateMaxNumber(randomNumber: Int) {
            if (randomNumber > MAX_RANDOM_NUMBER) {
                throw IllegalArgumentException(
                    ErrorMessage.getMaxNumberError(randomNumber, MAX_RANDOM_NUMBER)
                )
            }
        }

        private fun validateMinNumber(randomNumber: Int) {
            if (randomNumber < MIN_RANDOM_NUMBER) {
                throw IllegalArgumentException(
                    ErrorMessage.getMinNumberError(randomNumber, MIN_RANDOM_NUMBER)
                )
            }
        }
    }
}
