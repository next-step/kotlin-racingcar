package racingcar.infra

import racingcar.domain.NumberGenerator
import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int {
        return Random.nextInt(MAX_BOUND)
    }

    companion object {
        private const val MAX_BOUND: Int = 9
    }
}
