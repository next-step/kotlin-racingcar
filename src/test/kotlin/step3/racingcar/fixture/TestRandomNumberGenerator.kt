package step3.racingcar.fixture

import step3.racingcar.domain.NumberGenerator

class TestRandomNumberGenerator(private val testValue: Int = DEFAULT_TEST_VALUE) : NumberGenerator {
    override fun value(): Int = testValue

    companion object {
        private const val DEFAULT_TEST_VALUE = 1
    }
}
