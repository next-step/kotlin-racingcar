package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "canMove가 true일 경우 차들은 전진한다" {
        val cars = listOf(Car(name = "car1"), Car(name = "car2"))
        val racingGame = RacingGame(cars)

        racingGame.race(3) { true }

        cars.forAll {
            it.position shouldBe 3
        }
    }

    "canMove가 false 경우 차들은 전진하지 않는다" {
        val cars = listOf(Car(name = "car1"), Car(name = "car2"))
        val racingGame = RacingGame(cars)

        racingGame.race(3) { false }

        cars.forAll {
            it.position shouldBe 0
        }
    }
})
