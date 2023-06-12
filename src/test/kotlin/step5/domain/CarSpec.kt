package step5.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarSpec : DescribeSpec({
    describe("자동차 생성") {
        context("자동차가 생성되면") {
            val car = Car(name = "test")

            it("자동차의 이름이 설정된다") {
                car.name shouldBe "test"
            }

            it("자동차의 위치는 0이다") {
                car.position shouldBe 0
            }
        }

        context("자동차의 이름이 1자 미만이면") {
            it("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Car(name = "")
                }
            }
        }

        context("자동차의 이름이 5자 초과이면") {
            it("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Car(name = "123456")
                }
            }
        }
    }

    describe("자동차 전진") {
        context("자동차가 전진하면") {
            val car = Car(name = "test", moveForwardCondition = { true })

            it("자동차의 위치는 1 증가한다") {
                car.moveForwardRandomly()

                car.position shouldBe 1
            }
        }

        context("자동차가 전진하지 못하면") {
            val car = Car(name = "test", moveForwardCondition = { false })

            it("자동차의 위치는 변하지 않는다") {
                car.moveForwardRandomly()

                car.position shouldBe 0
            }
        }
    }
})
