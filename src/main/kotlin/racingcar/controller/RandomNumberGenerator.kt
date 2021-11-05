package racingcar.controller

import racingcar.domain.ATTEMPT_NUMBER_RANGE
import racingcar.domain.IRandomNumberGenerator

class RandomNumberGenerator : IRandomNumberGenerator {
    override fun getGeneratedNumber(): Int {
        return ATTEMPT_NUMBER_RANGE.random()
    }
}
