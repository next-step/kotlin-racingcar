package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RandomMoveRuleTest : FunSpec({
    test("4이상의 숫자가 주어지면 움직일 거리로 1이 반환된다") {
        val result = RandomMoveRule(RandomNumberGeneratorMock(4)).determineMoveDistance()

        result shouldBe 1
    }
    test("4보다 작은 숫자가 주어지면 움직일 거리로 0이 반환된다") {
        val result = RandomMoveRule(RandomNumberGeneratorMock(3)).determineMoveDistance()

        result shouldBe 0
    }
})
