package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({

    "자동차 동작(전진 혹은 정지) 테스트" {
        val numbers = listOf(4, 9, 0, 3, 10, -1)
        val indicator = Indicator(numbers)
        forAll(
            row(1, 1),
            row(2, 1),
            row(3, 0),
            row(4, 0),
            row(5, 0),
            row(6, 0)
        ) { turn, expectedDistance ->
            val car = Car(indicator)
            car.go(turn)
            val actualDistance = car.currentLocation()
            actualDistance shouldBe expectedDistance
        }
    }
})
