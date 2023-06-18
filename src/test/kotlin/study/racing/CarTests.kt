package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racing.car.Car

class CarTests : StringSpec({

    "Car 의 초기 totalMoved 는 0 이다" {
        val sut = Car("A")
        sut.totalMoved shouldBe 0
    }

    "movementCondition 에서 반환한 값 만큼 전진한다" {
        val sut = Car("A")
        sut.move { 1 }
        sut.totalMoved shouldBe 1
    }
})
