package next.step.racing.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarsTest : FunSpec({
    context("move") {
        test("모든 차가 전략에 따라 이동한다.") {
            Cars.from(5).move { 1 } shouldBe Cars.from(5, Position(1))
        }
    }

    context("positions") {
        test("모든 차의 위치를 제공한다.") {
            Cars.from(5, Position(4)).positions() shouldBe listOf(4, 4, 4, 4, 4)
        }
    }
})
