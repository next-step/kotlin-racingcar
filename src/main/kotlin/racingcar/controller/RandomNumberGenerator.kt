package racingcar.controller

import racingcar.domain.ATTEMPT_NUMBER_RANGE
import racingcar.domain.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun getGeneratedNumber(): Int {
        return ATTEMPT_NUMBER_RANGE.random()
    }
}
