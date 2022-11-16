package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차의 처음 위치는 0이에요" {
        val car = Car()
        car.currentLocation() shouldBe 0
    }

    "자동차는 4 ~ 9의 숫자일 때 1 만큼 이동해요" {
        (4..9).forEach { number ->
            val car = Car()
            car.move(number)

            car.currentLocation() shouldBe 1
        }
    }

    "자동차는 0~3의 숫자일 때 이동하지 않아요" {
        (0..3).forEach { number ->
            val car = Car()
            car.move(number)

            car.currentLocation() shouldBe 0
        }
    }
})
