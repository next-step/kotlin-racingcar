package racingcar.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({
    context("이동") {
        test("인자로 들어온 거리만큼 이동한다") {
            val initialPosition = 0
            val car = Car(
                order = 1,
                name = CarName("test"),
                position = initialPosition,
            )

            val moveDistance = 3
            car.move(moveDistance)

            car.position shouldBe initialPosition + moveDistance
        }
    }

    context("현재 상태 캡쳐") {
        test("현재 상태를 캡쳐해서 반환한다") {
            val order = 0
            val position = 1
            val car = Car(order, CarName("test"), position)

            val result = car.capture()

            result.order shouldBe order
            result.name shouldBe car.name
            result.position shouldBe position
        }
    }
})
