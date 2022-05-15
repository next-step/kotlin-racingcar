package racingcar.painter

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.car.Car
import racingcar.car.Position
import racingcar.game.GameResult

internal class GameResultPainterTest : StringSpec({

    "주어진 게임 결과를 문자열로 출력한다" {
        // given
        class StubCar(val position: Int) : Car {
            override fun forward(): Car = this
            override fun position(): Position = Position(position)
        }

        val gameResults = listOf(
            GameResult(listOf(StubCar(1), StubCar(0), StubCar(1))),
            GameResult(listOf(StubCar(2), StubCar(2), StubCar(3))),
            GameResult(listOf(StubCar(3), StubCar(2), StubCar(5))),
        )

        val result = GameResultPainter.from(gameResults)

        result shouldBe """
            -
            
            -
            
            --
            --
            ---
            
            ---
            --
            -----
        """.trimIndent()
    }
})
