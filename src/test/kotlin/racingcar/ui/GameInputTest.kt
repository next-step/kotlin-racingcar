package racingcar.ui

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.car.Position

internal class GameInputTest : FreeSpec({

    "예외 상황" - {
        listOf(
            Triple("round 에 0 을 넣은 경우", GameInput("car", 0), "round 는 1 이상이어야 합니다"),
            Triple("round 에 -1 을 넣은 경우", GameInput("car", -1), "round 는 1 이상이어야 합니다"),
            Triple("자동차 이름을 제공하지 않은 경우", GameInput("  ", 1), "자동차는 1대 이상이어야 합니다"),
            Triple("5자가 넘어가는 이름을 제공한 경우", GameInput("foo,bar,foobar", 1), "자동차 이름은 5자를 넘을 수 없습니다"),
        ).forEach { (title, input, expected) ->
            "$title 에러가 발생한다" {
                val exception = shouldThrow<IllegalArgumentException> { input.toRacingCars() }

                exception.message shouldBe expected
            }
        }
    }

    "주어진 input 에 따라 자동차와 round 를 반환한다" - {
        val input = GameInput("car", 10)

        input.round shouldBe 10
        val cars = input.toRacingCars()
        cars shouldHaveSize 1
        cars.first().name() shouldBe "car"
        cars.first().position() shouldBe Position(0)
    }
})
