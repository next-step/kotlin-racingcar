package racingcar.domain.model

import racingcar.domain.rule.RacingRule
import racingcar.domain.rule.RacingRuleImpl

class Car(val name: String, private val rule: RacingRule = RacingRuleImpl()) {
    var position: Int = 0
        private set

    fun move() {
        if (!rule.canMove()) {
            return
        }
        position++
    }
}
