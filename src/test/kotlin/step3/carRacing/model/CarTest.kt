package step3.carRacing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차는 무작위 값이 4 미만일 경우 멈춘다" {
        val car = Car()
        car.tryRace(3)
        car.curPosition shouldBe 0
    }
    "자동차는 무작위 값이 4 이상일 경우 전진한다" {
        val car = Car()
        car.tryRace(4)
        car.curPosition shouldBe 1
    }
})
