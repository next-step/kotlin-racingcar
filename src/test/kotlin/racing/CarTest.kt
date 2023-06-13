package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차 이름이 5자 초과시 예외 발생한다" {
        val exception = shouldThrow<IllegalArgumentException> { Car("Elizabeth") }

        exception.message shouldBe "자동차 이름은 5자 이하여야 합니다"
    }

    "자동차가 움직이면 위치가 1 증가한다" {
        val car = Car("name")

        car.move(movePolicy = { true })

        car.position shouldBe 1
    }

    "자동차가 정지하면 위치가 증가하지 않는다." {
        val car = Car("name")

        car.move(movePolicy = { false })

        car.position shouldBe 0
    }

    "다른 자동차와 같은 포지션인지 반환한다" {
        val car = Car(name = "me", position = 2)
        val otherCar = Car(name = "other", position = 2)

        car.hasSamePosition(otherCar) shouldBe true
    }
})
