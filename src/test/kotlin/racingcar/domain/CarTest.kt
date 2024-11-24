package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car 최초 생성시 step 은 0이다" {
        Car(name = "car1").position shouldBe 0
    }

    "Car 전진 조건이 true 일 경우 1만큼 전진한다" {
        val sut = Car(name = "car1")
        sut.moveForward { true }
        sut.position shouldBe 1
    }

    "Car 전진 조건이 false 일 경우 전진하지 않는다" {
        val sut = Car(name = "car1")
        sut.moveForward { false }
        sut.position shouldBe 0
    }

    "Car 이름이 5자 초과시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Car("aaa_aaa")
        }
    }
})
