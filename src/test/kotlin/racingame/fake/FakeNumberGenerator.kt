package racingame.fake

import racingame.domain.NumberGenerator

class FakeNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate(): Int {
        return number
    }
}
