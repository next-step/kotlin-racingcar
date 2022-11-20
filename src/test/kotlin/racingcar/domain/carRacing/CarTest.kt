package racingcar.domain.carRacing

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차 전진 테스트" {
        val car = Car("난빠름")
        forAll(
            row(4, 1),
            row(6, 2),
            row(8, 3),
            row(5, 4),
            row(7, 5),
            row(9, 6)
        ) { number, expectedDistance ->
            car.go(number)
            val actualDistance = car.currentDistance()
            actualDistance shouldBe expectedDistance
        }
    }

    "자동차 정지 테스트" {
        val car = Car("난느림")
        forAll(
            row(1, 0),
            row(2, 0),
            row(3, 0),
            row(0, 0),
            row(-1, 0)
        ) { number, expectedDistance ->
            car.go(number)
            val actualDistance = car.currentDistance()
            actualDistance shouldBe expectedDistance
        }
    }
})
