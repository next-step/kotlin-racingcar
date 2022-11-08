package racingcar.condition

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import io.mockk.every
import io.mockk.mockkObject
import racingcar.util.RandomNumberGenerator

internal class RandomMoveConditionTest : FunSpec({
    context("RandomGenerator가 4 이상을 반환하면, true를 반환한다.") {
        mockkObject(RandomNumberGenerator)
        val numberArb = Arb.int(4, 9)
        checkAll(numberArb) { num ->
            every { RandomNumberGenerator.generate(any()) } returns num
            RandomMoveCondition().isAvailable() shouldBe true
        }
    }

    context("RandomGenerator가 4 이하를 반환하면, false를 반환한다.") {
        mockkObject(RandomNumberGenerator)
        val numberArb = Arb.int(0, 3)
        checkAll(numberArb) { num ->
            every { RandomNumberGenerator.generate(any()) } returns num
            RandomMoveCondition().isAvailable() shouldBe false
        }
    }
})
