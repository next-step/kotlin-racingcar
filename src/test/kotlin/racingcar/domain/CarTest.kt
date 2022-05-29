package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("자동차 객체를 생성할 때") {
        test("이름이 빈 값이면, 예외가 발생한다.") {
            // when then
            val exception = shouldThrow<IllegalArgumentException> { Car(name = CarName.of("")) }
            exception.message shouldBe "자동차의 이름은 빈 값이나 공백이 될 수 없습니다. name: "
        }
    }

    context("move 함수를 호출할 때") {
        test("자동차에게 주어지는 연료 값이 4이상이면 전진할 수 있다.") {
            // given
            val sut = Car(name = CarName.of("charlie"))

            // when
            val movedCar = sut.moveForward(fuel = 4)

            // then
            movedCar.distanceMoved shouldBe 1
        }

        test("자동차에게 주어지는 연료 값이 4미만이면 멈춰있는다.") {
            // given
            val sut = Car(name = CarName.of("charlie"))

            // when
            val movedCar = sut.moveForward(fuel = 3)

            // then
            movedCar.distanceMoved shouldBe 0
        }
    }
})
