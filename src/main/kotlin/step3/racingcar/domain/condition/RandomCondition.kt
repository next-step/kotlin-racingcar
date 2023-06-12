package step3.racingcar.domain.condition

import step3.racingcar.utils.RandomUtils

object RandomCondition : Condition {
    private val START_RANDOM_NUM = 0
    private val END_RANDOM_NUM = 9
    private val MIN_NUMBER = 4

    override fun canMove(): Boolean {
        val randomNumber = RandomUtils.generate(START_RANDOM_NUM, END_RANDOM_NUM)
        return MIN_NUMBER <= randomNumber
    }
}
