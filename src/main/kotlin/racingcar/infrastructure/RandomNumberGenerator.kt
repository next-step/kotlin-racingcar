package racingcar.infrastructure

import racingcar.domain.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (0..9).random()
    }
}
