package racingcar

import racingcar.strategy.ConditionGenerateStrategy
import racingcar.strategy.RandomStrategy

class Car(position: Int = DEFAULT_POSITION, val conditionGenerateStrategy: ConditionGenerateStrategy = RandomStrategy()) {
    var position = position
        private set

    fun move(): Int {
        if (conditionGenerateStrategy.generate()) {
            position++
        }

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 1
    }
}
