package step3_4.racing.car

import step3_4_5.domain.racing.NumberGenerator
import kotlin.random.Random

class FakeNumberGenerator(private val fakeFrom: Int, private val fakeUntil: Int) : NumberGenerator {
    override fun generateNumber(): Int {
        return Random.nextInt(fakeFrom, fakeUntil)
    }
}
