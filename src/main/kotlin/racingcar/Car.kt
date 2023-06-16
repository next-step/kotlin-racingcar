package racingcar

import racingcar.strategy.ConditionGenerateStrategy
import racingcar.strategy.RandomStrategy

class Car(position: Int = DEFAULT_POSITION) {
    var position = position
        private set
    var conditionGenerateStrategy: ConditionGenerateStrategy = RandomStrategy()

    fun move(): Int {
        if (conditionGenerateStrategy.generate() >= THRESHOLD) {
            position++
        }

        return position
    }

    companion object {
        const val DEFAULT_POSITION = 1
        const val THRESHOLD = 4
    }
}
