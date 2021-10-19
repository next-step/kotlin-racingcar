package racingcar.model

import racingcar.util.Validation
import racingcar.constant.Constant
import racingcar.util.Engine
import java.util.Random

data class Car(val distance: String = Constant.EMPTY) {
    private val random = Random()

    fun getResult(): Car {
        val num = random.nextInt(Validation.MAX_CONDITION)
        return if (Validation.isMatchCondition(num)) {
            Engine.forward(this)
        } else {
            this
        }
    }
}
