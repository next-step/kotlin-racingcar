package racingcar

import racingcar.rule.RacingRule
import racingcar.util.Generator

class AlwaysMoveRule : RacingRule {
    override fun canMove(): Boolean = true
}

class NeverMoveRule : RacingRule {
    override fun canMove(): Boolean = false
}

class FourToNineGenerator : Generator {
    override val value: Int
        get() = 4
}

class ZeroToThreeGenerator : Generator {
    override val value: Int
        get() = 3
}
