package step3.racingcar.fixture

import step3.racingcar.domain.RandomNumber

class TestRandomNumberGenerator(private val testValue: Int) : RandomNumber {
    override fun value(): Int = testValue
}
