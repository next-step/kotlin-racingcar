package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "4 이상인 경우 자동차 객체가 이동 한다" {
        val pobi = Car("pobi", moveCondition = SuccessMovement())
        val cars = Cars(listOf(pobi))
        cars.move()

        cars.cars[0].position shouldBe 1
    }

    "4 미만인 경우 자동차 객체가 이동하지 않는다" {
        val pobi = Car("pobi", moveCondition = FailMovement())
        val cars = Cars(listOf(pobi))
        cars.move()

        cars.cars[0].position shouldBe 0
    }
})
