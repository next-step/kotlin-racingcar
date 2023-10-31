package carRacing.model

import carRacing.RaceRuleType

class Car(curPosition: Int = 0, carName: String = "") {
    var curPosition:Int = curPosition
        private set

    var carName:String = carName
        private set

    fun tryRace(rule: RaceRuleType) {
        if (rule(this)) {
            curPosition++
        }
    }

}
