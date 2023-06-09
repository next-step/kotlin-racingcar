package next.step.racing.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("position") {
        test("차의 시작 위치는 0") {
            Car.init().position() shouldBe 0
        }
    }

    context("move by strategy") {
        data class StrategyExpected(val init: Int, val strategy: () -> Int, val expected: Int)
        withData(
            StrategyExpected(0, { 1 }, 1),
            StrategyExpected(10, { 1 }, 11),
            StrategyExpected(20, { 5 }, 25)
        ) { (init, strategy, expected) ->
            Car.at(init).move(strategy) shouldBe Car.at(expected)
        }
    }
})
