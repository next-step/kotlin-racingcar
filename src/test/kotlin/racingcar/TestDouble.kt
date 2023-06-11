package racingcar

import racingcar.rule.RacingRule

class AlwaysMoveRule : RacingRule {
    override fun canMove(): Boolean = true
}

class NeverMoveRule : RacingRule {
    override fun canMove(): Boolean = false
}
