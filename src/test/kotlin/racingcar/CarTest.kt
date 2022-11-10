package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    val carName = "foo"

    "4이상이면 전진" {
        val moveCondition = 4
        val car = Car(carName)

        val initPosition = car.position
        val movedCar = car.move(moveCondition)

        movedCar.position shouldBeGreaterThan initPosition
    }

    "4미만이면 멈춤" {
        val moveCondition = 3
        val car = Car(carName)

        val initPosition = car.position
        val movedCar = car.move(moveCondition)

        movedCar.position shouldBe initPosition
    }

    "최초 포지션 0" {
        val car = Car(carName)

        car.position shouldBe 0
    }
})
