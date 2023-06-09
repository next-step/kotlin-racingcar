package next.step.racing.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingTest : FunSpec({
    context("race") {
        test("제공된 차의 개수와 횟수만큼 주어진 이동전략을 통해 경주를 하고 전체 차의 위치정보를 제공한다") {
            Racing.race(3, 5) { 1 } shouldBe listOf(
                listOf(1, 1, 1),
                listOf(2, 2, 2),
                listOf(3, 3, 3),
                listOf(4, 4, 4),
                listOf(5, 5, 5)
            )
        }
    }
})
