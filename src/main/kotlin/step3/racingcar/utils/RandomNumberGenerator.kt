package step3.racingcar.utils

import step3.racingcar.domain.NumberGenerator
import step3.racingcar.domain.NumberGenerator.Companion.RANGE_END
import step3.racingcar.domain.NumberGenerator.Companion.RANGE_START

class RandomNumberGenerator : NumberGenerator {
    override fun value(): Int = generate()

    private fun generate(): Int = (RANGE_START..RANGE_END).random()
}
