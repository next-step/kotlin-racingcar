package racingcar.racingcar

import racingcar.util.RandomUtil

class IndicatorGenerator {
    fun generate(turnCount: Int): Indicator {
        val indicators = List(turnCount) { RandomUtil.generateRandomNumber(0, 9) }
        return Indicator(indicators)
    }
}
