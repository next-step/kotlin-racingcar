package next.step.racing.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import next.step.racing.domain.car.Car
import next.step.racing.domain.car.CarName
import next.step.racing.domain.car.CarPosition
import next.step.racing.util.DrivingStrategy

class CarTest : DescribeSpec({

    val name = CarName("GV80")

    describe("Car method") {

        val car = Car(name = name, pos = CarPosition(1))

        context("차의 위치") {
            it("Int로 제공") {
                car.position() shouldBe 1
            }
        }

        context("차가 지정된 위치에 있으면") {
            it("참") {
                car.isAt(CarPosition(1)) shouldBe true
            }

            it("거짓") {
                car.isAt(CarPosition(2)) shouldBe false
            }
        }

        context("차를 전략에 따라 이동시켜 차의 위치가 시작 위치 기준으로 바뀜") {
            data class StrategyExpected(val init: Int, val strategy: DrivingStrategy, val expected: Int)

            withData(
                nameFn = { "move from ${it.init} with strategy: ${it.strategy()} -> ${it.expected}" },
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
    }
})
