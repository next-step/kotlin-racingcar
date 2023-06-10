package next.step.racing.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import next.step.racing.util.DrivingStrategy

class CarTest : FunSpec({
    val name = CarName("GV80")
    context("position") {
        val car = Car(name = name, pos = CarPosition(1))
        test("차의 시작 위치는 0") {
            car.position() shouldBe 1
        }
        test("차가 지정된 위치에 있으면 참") {
            car.isAt(CarPosition(1)) shouldBe true
        }
        test("차가 지정된 위치에 없으면 거짓") {
            car.isAt(CarPosition(2)) shouldBe false
        }
    }

    context("move by strategy") {
        data class StrategyExpected(val init: Int, val strategy: DrivingStrategy, val expected: Int)
        withData(
            StrategyExpected(0, { 1 }, 1),
            StrategyExpected(10, { 1 }, 11),
            StrategyExpected(20, { 5 }, 25)
        ) { (pos, strategy, expected) ->
            Car(name = name, pos = CarPosition(pos)).move(strategy) shouldBe Car(
                name = name,
                pos = CarPosition(expected)
            )
        }
    }
})
