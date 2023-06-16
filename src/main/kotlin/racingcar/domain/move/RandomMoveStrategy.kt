package racingcar.domain.move

import racingcar.utils.RandomGenerator

class RandomMoveStrategy : Movable {

    override fun move(): Boolean {
        val randomNum = generateRandomNum()
        return conditionToMove(randomNum)
    }

    private fun conditionToMove(randomNum: Int) = randomNum >= BASE_NUMBER_TO_MOVE

    private fun generateRandomNum(): Int {

        val randomValue: Int = RandomGenerator.generateRandomNum(RANDOM_MINIMUM, RANDOM_MAXIMUM)
        if (randomValue < RANDOM_MINIMUM || randomValue > RANDOM_MAXIMUM) {
            throw IllegalArgumentException("랜덤값은 0,9 사이의 값이어야 합니다.")
        }
        return randomValue
    }

    companion object {
        const val BASE_NUMBER_TO_MOVE = 4
        const val RANDOM_MINIMUM = 0
        const val RANDOM_MAXIMUM = 9
    }
}
