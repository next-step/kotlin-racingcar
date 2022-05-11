package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({

    describe("move") {
        context("이동 전략이 true 이면") {
            it("전진한다") {
                val car = Car()
                car.move { true }
                car.location shouldBe Location(1)
            }
        }

        context("이동 전략이 false 이면") {
            it("멈춰있는다") {
                val car = Car()
                car.move { false }
                car.location shouldBe Location(0)
            }
        }
    }
})
