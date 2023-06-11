package racingcar.model

import racingcar.rule.RacingRule
import racingcar.rule.RacingRuleImpl

class Car(private val rule: RacingRule = RacingRuleImpl()) {
    var position: Int = 0
        private set

    fun move() {
        if (!rule.canMove()) {
            return
        }
        position++
    }
}
