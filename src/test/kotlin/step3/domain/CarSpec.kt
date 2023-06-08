package step3.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarSpec : DescribeSpec({

    describe("자동차 생성") {
        context("자동차가 생성되면") {
            it("자동차의 위치는 0이다.") {
                val car = Car()

                car.position shouldBe 0
            }
        }
    }

    describe("자동차 전진") {
        context("자동차가 전진하면") {
            val car = Car(Car.CarOption(position = 0, moveForwardCondition = { true }))

            it("자동차의 위치는 1 증가한다") {
                car.moveForwardRandomly()

                car.position shouldBe 1
            }
        }

        context("자동차가 전진하지 못하면") {
            val car = Car(Car.CarOption(position = 0, moveForwardCondition = { false }))

            it("자동차의 위치는 변하지 않는다") {
                car.moveForwardRandomly()

                car.position shouldBe 0
            }
        }
    }
})
