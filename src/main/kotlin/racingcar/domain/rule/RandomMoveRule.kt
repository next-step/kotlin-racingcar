package racingcar.domain.rule

class RandomMoveRule(
    private val randomNumberGenerator: RandomNumberGenerator,
) : MoveRule {
    override fun determineMoveDistance(): Int {
        val randomNumber = randomNumberGenerator.getNumber()
        return when (canMove(randomNumber)) {
            true -> DISTANCE_TO_MOVE
            false -> 0
        }
    }

    private fun canMove(randomNumber: Int): Boolean = randomNumber >= BASE_NUMBER

    companion object {
        private const val BASE_NUMBER = 4
        private const val DISTANCE_TO_MOVE = 1
    }
}
