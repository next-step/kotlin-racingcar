package step3.fake

import step3.domain.NumberGenerator

class FakeNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate(): Int {
        return number
    }
}
