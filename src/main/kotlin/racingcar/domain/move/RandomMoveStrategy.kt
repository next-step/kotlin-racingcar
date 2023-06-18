package racingcar.domain.move

class RandomMoveStrategy : Movable {

    override fun move(): Boolean {
        val randomNum = generateRandomNum()
        return conditionToMove(randomNum)
    }

    private fun conditionToMove(randomNum: Int) = randomNum >= BASE_NUMBER_TO_MOVE

    private fun generateRandomNum(): Int {

        val randomValue: Int = generateRandomNum(RANDOM_MINIMUM, RANDOM_MAXIMUM)

        return randomValue
    }

    private fun generateRandomNum(begin: Int, end: Int): Int {
        return (begin..end).random()
    }

    companion object {
        const val BASE_NUMBER_TO_MOVE = 4
        const val RANDOM_MINIMUM = 0
        const val RANDOM_MAXIMUM = 9
    }
}
