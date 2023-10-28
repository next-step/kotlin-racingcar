package racingcar.domain.rule

import racingcar.domain.rule.RandomNumberGenerator

class RandomNumberGeneratorMock(
    private val number: Int,
) : RandomNumberGenerator {
    override fun getNumber(): Int = number
}
