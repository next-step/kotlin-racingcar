package next.step.racing.domain.car

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarsTest : DescribeSpec({

    describe("Cars method") {
        context("move") {
            it("모든 차가 전략에 따라 이동한다.") {
                val cars = Cars(listOf(car("GV1", 5), car("GV3", 3), car("GV80", 10)))

                cars.move { 1 } shouldBe Cars(listOf(car("GV1", 6), car("GV3", 4), car("GV80", 11)))
            }
        }

        context("records") {
            it("모든 차의 기록을 제공한다.") {
                val cars = Cars(listOf(car("GV1", 5), car("GV3", 3)))

                cars.records() shouldBe listOf(CarRecord("GV1", 5), CarRecord("GV3", 3))
            }
        }

        context("winners") {
            it("position이 가장 큰 차이름을 제공한다.") {
                val cars = Cars(listOf(car("GV1", 5), car("GV3", 3), car("GV5", 10), car("GV80", 10)))

                cars.winners() shouldBe listOf(
                    "GV5",
                    "GV80"
                )
            }
        }
    }
})

private fun car(name: String, pos: Int) = Car(CarName(name), CarPosition(pos))
