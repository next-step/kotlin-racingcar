package racingcar.domain.carIndicator

import racingcar.util.RandomUtil

class IndicatorGenerator {
    fun generate(carCount: Int, turnCount: Int): List<TurnIndicator> {
        return List(turnCount) {
            val indicators = List(carCount) { RandomUtil.generateRandomNumber(0, 9) }
            TurnIndicator(indicators)
        }
    }
}
