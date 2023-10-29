package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.move.MoveAlwaysStrategy
import racing.model.move.MoveNeverStrategy

class CarTest : StringSpec({
    "자동차는 전진 또는 멈출 수 있다" {
        val car = Car(77, 77)

        val stopCar = car.move(MoveNeverStrategy())
        stopCar.id shouldBe car.id
        stopCar.position shouldBe car.position

        val unstoppableCar = car.move(MoveAlwaysStrategy())
        unstoppableCar.id shouldBe car.id
        unstoppableCar.position shouldBe car.position + 1
    }
})
