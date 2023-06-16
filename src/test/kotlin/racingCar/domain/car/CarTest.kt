package racingCar.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car가 주어진 이동 크기만큼 움직인다면, Car의 position은 이동한만큼 증가한다" {
        val fixMovePoint = 1
        val car = Car("A", FixedMovingEngine(fixMovePoint))
        val prevPosition = car.position

        car.move()

        car.position shouldBe prevPosition + fixMovePoint
    }
})
