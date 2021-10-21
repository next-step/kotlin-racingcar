package racingcar.car

import racingcar.util.Validation
import racingcar.constant.Constant
import racingcar.engine.Engine
import java.util.Random

class Car(private val engine: Engine) {
    private var distance = Constant.READY_STATUS
    private val random = Random()

    fun start(): Car {
        val num = random.nextInt(Validation.MAX_CONDITION)
        if (Validation.isMatchCondition(num)) {
            distance = engine.forward(distance)
        }
        return this
    }

    fun getLocation(): String {
        return distance
    }
}
