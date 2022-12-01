package study.racingcar.domain.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racingcar.domain.car.Car
import study.racingcar.domain.car.Power

internal class WinnerTest : StringSpec({
    "승자를 알 수 있다" {
        val cars = listOf(Car("소나타"), Car("그렌저"))
        cars[0].move(Power(4))
        cars[0].move(Power(4))

        Winner(cars).findWinners() shouldBe listOf(cars[0])
    }

    "승자는 여러명 일 수 있다" {
        val cars = listOf(Car("소나타"), Car("그렌저"), Car("카니발"))
        cars[0].move(Power(4))
        cars[1].move(Power(4))

        Winner(cars).findWinners() shouldBe listOf(cars[0], cars[1])
    }
})
