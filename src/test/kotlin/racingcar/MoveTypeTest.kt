package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import racingcar.utils.RandomNumberGenerator

internal class MoveTypeTest : BehaviorSpec({
    Given("MoveType 조건에 따라 자동차는") {
        mockkObject(RandomNumberGenerator)
        When("전진 가능한 상태라면") {
            every { RandomNumberGenerator.generate(any()) } returns 8
            Then("전진한다.") {
                MoveType.isPossibleMove(MoveType.DEFAULT) shouldBe true
            }
        }

        When("전진 불가능 상태라면") {
            every { RandomNumberGenerator.generate(any()) } returns 0
            Then("전진하지 않는다.") {
                MoveType.isPossibleMove(MoveType.DEFAULT) shouldBe false
            }
        }
        unmockkAll()
    }
})
