package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.racingcar.Car

class CarTest : StringSpec({
    "자동차 전진 테스트" {
        listOf(
            4 to "-",
            9 to "-",
            0 to "",
            3 to "",
            10 to "",
            -1 to ""
        ).forEach { (input, expected) ->
            val car = Car()
            car.go(input)
            car.currentLocation() shouldBe expected
        }
    }
})
