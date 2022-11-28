package step3.racingcar.utils

import step3.racingcar.domain.RandomNumber
import step3.racingcar.domain.RandomNumber.Companion.RANGE_END
import step3.racingcar.domain.RandomNumber.Companion.RANGE_START

class RandomNumberGenerator : RandomNumber {
    override fun value(): Int = generate()

    private fun generate(): Int = (RANGE_START..RANGE_END).random()
}
