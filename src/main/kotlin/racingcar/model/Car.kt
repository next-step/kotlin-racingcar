package racingcar.model

import racingcar.rule.RacingRule

class Car(private val rule: RacingRule) {
    var position: Int = 0
        private set

    fun move() {
        if (!rule.canMove()) {
            return
        }
        position++
    }
}
