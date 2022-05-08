package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({

    describe("move") {
        context("이동 전략이 true 이면") {
            it("전진한다") {
                val car = Car(0)
                car.move { true }
                car.position shouldBe 1
            }
        }

        context("이동 전략이 false 이면") {
            it("멈춰있는다") {
                val car = Car(0)
                car.move({ false })
                car.position shouldBe 0
            }
        }
    }
})
