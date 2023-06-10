package racingcar.domain

interface RaceMoveRule {
    fun canMove(car: Car): Boolean
}

class RandomRaceMoveRule(private val randomGenerator: RandomGenerator) : RaceMoveRule {
    override fun canMove(car: Car): Boolean {
        return MOVE_CRITERIA <= randomGenerator.generate(FROM, UNTIL)
    }

    companion object {
        private const val MOVE_CRITERIA = 4
        private const val FROM = 0
        private const val UNTIL = 9
    }
}
