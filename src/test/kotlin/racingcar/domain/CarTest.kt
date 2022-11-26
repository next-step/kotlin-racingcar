package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("객체 생성") {
        test("자동차 객체를 생성한다.") {
            shouldNotThrowAny {
                Car()
            }
        }
    }
    context("moveForward()") {
        test("자동차가 1칸 전진한다.") {
            val car = Car()
            val currentPosition = car.moveForward { true }
            currentPosition.position shouldBe 1
        }
    }
})
