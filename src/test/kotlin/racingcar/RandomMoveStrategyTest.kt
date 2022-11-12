package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import racingcar.utils.RandomNumberGenerator

internal class RandomMoveStrategyTest : FunSpec({
    context("RandomGenerator 값이 4 이상이면, 움직일 수 있는 상태이다.") {
        mockkObject(RandomNumberGenerator)
        every { RandomNumberGenerator.generate(any()) } returns 9
        RandomMoveStrategy().isPossibleMove() shouldBe true
        unmockkAll()
    }

    context("RandomGenerator 값이 4 미만이면, 움직이지 못하는 상태이다.") {
        mockkObject(RandomNumberGenerator)
        every { RandomNumberGenerator.generate(any()) } returns 0
        RandomMoveStrategy().isPossibleMove() shouldBe false
        unmockkAll()
    }
})
