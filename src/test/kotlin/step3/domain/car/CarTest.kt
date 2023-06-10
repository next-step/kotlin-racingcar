package step3.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "Car의 position이 정상적으로 변경된다" {
        val fixMovePoint = 1
        val car = Car(0, FixedMovePointDecider(fixMovePoint))
        val prevPosition = car.getPosition()

        car.move()

        car.getPosition() shouldBe prevPosition + fixMovePoint
    }
})
