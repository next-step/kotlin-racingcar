package racingcar.domain

class FakeTrueGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = true
}

class FakeFalseGenerator : RandomGenerator {
    override fun getRandomValidation(): Boolean = false
}
