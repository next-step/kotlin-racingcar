package carracing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "자동차 이름, 거리를 가지고 있다" {
        // given
        val carName = "TestCar"
        val carDistance = 3

        // when
        val car = Car(carName, carDistance)

        // then
        car.distance shouldBe carDistance
        car.name shouldBe carName
    }

    "move 는 현재 거리에서 이동거리를 더한다" {
        // given
        val nowDistance = 10
        val moveDistance = 20
        val car = Car("testCar", nowDistance)

        // when
        car.move(moveDistance)

        // then
        car.distance shouldBe nowDistance + moveDistance
    }
})
