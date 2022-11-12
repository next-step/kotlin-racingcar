package step3.domain

import racingcar.domain.RandomGenerator

class FakeTrueGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = true
}

class FakeFalseGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = false
}
