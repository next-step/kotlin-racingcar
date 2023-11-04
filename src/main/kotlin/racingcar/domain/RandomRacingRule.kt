package racingcar.domain

import racingcar.Racing

class RandomRacingRule(
    private val random: NumberGenerator<Int> = NumberGenerator { start: Int, end: Int -> IntRange(start, end).random() },
    private val condition: MovingCondition = MovingCondition(Racing.RANDOM_START, Racing.RANDOM_END, Racing.MOVE_FORWARD_CONDITION)
) : RacingRule {
    override fun canMoveForward(): Boolean = condition.forwardCondition <= random.apply(condition.start, condition.end)
}
