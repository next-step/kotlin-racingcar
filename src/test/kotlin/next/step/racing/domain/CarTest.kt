package next.step.racing.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import next.step.racing.service.DrivingStrategy

class CarTest : FunSpec({
    context("position") {
        test("차의 시작 위치는 0") {
            Car(Position(1)).position() shouldBe Position(1)
        }
    }

    context("move by strategy") {
        data class StrategyExpected(val init: Int, val strategy: DrivingStrategy, val expected: Int)
        withData(
            StrategyExpected(0, { 1 }, 1),
            StrategyExpected(10, { 1 }, 11),
            StrategyExpected(20, { 5 }, 25)
        ) { (pos, strategy, expected) ->
            Car(Position(pos)).move(strategy) shouldBe Car(Position(expected))
        }
    }
})
