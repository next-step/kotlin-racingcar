package racingcar.strategy

class RandomStrategy : Strategy {
    override val canMove get() = greaterThanOrEqualToMovableValue(getRandom(RANDOM_START_NUM, RANDOM_END_NUM))

    companion object {
        const val RANDOM_START_NUM = 0
        const val RANDOM_END_NUM = 9
        const val MOVABLE_VALUE = 4
    }

    private fun getRandom(randomStartNum: Int, randomEndNum: Int) = (randomStartNum..randomEndNum).random()
    private fun greaterThanOrEqualToMovableValue(randomValue: Int) = randomValue >= MOVABLE_VALUE
}
