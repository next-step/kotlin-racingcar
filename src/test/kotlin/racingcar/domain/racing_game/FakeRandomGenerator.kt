package racingcar.domain.racing_game

import racingcar.domain.random.RandomGenerator

class FakeTrueGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = true
}

class FakeFalseGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = false
}
