package racingcar.controller

import racingcar.domain.ATTEMPT_NUMBER_RANGE
import racingcar.domain.IRandomNumberGenerator

class RandomNumberNumberGenerator : IRandomNumberGenerator {
    override fun getGeneratedNumber(): Int {
        return ATTEMPT_NUMBER_RANGE.random()
    }
}
