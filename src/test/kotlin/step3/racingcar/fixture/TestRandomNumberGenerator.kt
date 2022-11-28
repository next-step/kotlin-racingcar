package step3.racingcar.fixture

import step3.racingcar.domain.RandomNumber

class TestRandomNumberGenerator(private val testValue: Int = DEFAULT_TEST_VALUE) : RandomNumber {
    override fun value(): Int = testValue

    companion object {
        private const val DEFAULT_TEST_VALUE = 1
    }
}
