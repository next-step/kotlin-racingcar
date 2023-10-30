package step4.carRacingWinner.model

import step4.carRacingWinner.RaceRuleType


class Car(private var curPosition: Int = 0, private var carName: String = "") {
    fun tryRace(rule: RaceRuleType) {
        if (rule(this)) {
            curPosition++
        }
    }

    fun getCurPosition() = this.curPosition
    fun getCarName() = this.carName
}
