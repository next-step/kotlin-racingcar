package racingcar.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("이동") {
        test("인자로 들어온 거리만큼 이동한다") {
            val initialPosition = 0
            val car = Car(
                name = CarName("test"),
                position = initialPosition,
            )

            val moveDistance = 3
            car.move(moveDistance)

            car.position shouldBe initialPosition + moveDistance
        }
    }
})
