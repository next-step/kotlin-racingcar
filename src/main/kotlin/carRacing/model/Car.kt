package carRacing.model

import carRacing.utils.Validation
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

    companion object{
        val validateCarName = { carName: String ->
            Validation.validate<String>(carName, { it.length < 6 }, "자동차 이름은 5자를 초과할 수 없습니다")
        }
    }
}
