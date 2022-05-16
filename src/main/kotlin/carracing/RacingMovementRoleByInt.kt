package carracing

class RacingMovementRoleByInt(
    private val minForwardNumber: Int,
    private val minRandomNumber: Int,
    private val maxRandomNumber: Int
) : RacingMovementRole<Int> {

    @Throws(IllegalArgumentException::class)
    override fun getMoveDistance(argument: Int): Int {
        validate(argument)
        if (argument >= minForwardNumber) {
            return 1
        }
        return 0
    }

    @Throws(IllegalArgumentException::class)
    override fun validate(argument: Int) {
        validateMinNumber(argument)
        validateMaxNumber(argument)
    }

    private fun validateMaxNumber(randomNumber: Int) {
        if (randomNumber > maxRandomNumber) {
            throw IllegalArgumentException(
                ErrorMessage.getMaxNumberError(randomNumber, maxRandomNumber)
            )
        }
    }

    private fun validateMinNumber(randomNumber: Int) {
        if (randomNumber < minRandomNumber) {
            throw IllegalArgumentException(
                ErrorMessage.getMinNumberError(randomNumber, minRandomNumber)
            )
        }
    }
}
