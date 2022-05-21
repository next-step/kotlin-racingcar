package racingcar.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.car.Car
import racingcar.car.Position

internal class GameWinnerFinderTest : StringSpec({

    "게임 결과가 없으면 에러가 발생한다" {
        shouldThrow<NoSuchElementException> {
            GameWinner.of(emptyList())
        }
    }

    "주어진 게임 결과에서 우승자들을 반환한다" {
        // given
        val makeCar = { name: String, position: Int ->
            object : Car {
                override fun name(): String = name
                override fun forward(): Car = this
                override fun position(): Position = Position(position)
            }
        }
        val results = GameResult(
            listOf(
                makeCar("car1", 1),
                makeCar("car2", 4),
                makeCar("car3", 3),
                makeCar("car4", 4),
            )
        )

        // when
        val winners = GameWinner.of(listOf(results))

        // then
        winners.map { it.name() } shouldBe listOf("car2", "car4")
    }
})
