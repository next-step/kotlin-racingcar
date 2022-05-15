package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("move 함수를 호출할 때") {
        test("자동차에게 주어지는 값이 4이상이면 전진할 수 있다.") {
            // given
            val car = Car()

            // when
            val movedCar = car.move(4)

            // then
            movedCar.distanceMoved shouldBe 1
        }

        test("자동차에게 주어지는 값이 4미만이면 멈춰있는다.") {
            // given
            val car = Car()

            // when
            val movedCar = car.move(3)

            // then
            movedCar.distanceMoved shouldBe 0
        }
    }
})
