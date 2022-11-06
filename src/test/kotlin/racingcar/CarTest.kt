package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    "4이상이면 전진" {
        val moveCondition = 4
        val car = Car()

        val initPosition = car.position
        car.move(moveCondition)

        car.position shouldBeGreaterThan initPosition
    }

    "4미만이면 멈춤" {
        val moveCondition = 3
        val car = Car()

        val initPosition = car.position
        car.move(moveCondition)

        car.position shouldBe initPosition
    }

    "최초 포지션 0" {
        val car = Car()

        car.position shouldBe 0
    }
})
