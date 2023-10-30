package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.move.MoveAlwaysStrategy
import racing.model.move.MoveNeverStrategy

class CarTest : StringSpec({
    "자동차는 전진 또는 멈출 수 있다" {
        val car = Car("77", 77)

        val stopCar = car.move(MoveNeverStrategy())
        stopCar.name shouldBe car.name
        stopCar.position shouldBe car.position

        val unstoppableCar = car.move(MoveAlwaysStrategy())
        unstoppableCar.name shouldBe car.name
        unstoppableCar.position shouldBe car.position + 1
    }

    "각 자동차에 이름을 부여할 수 있다" {
        TODO()
    }

    "자동차 이름은 5자를 초과할 수 없다" {
        TODO()
    }
})
