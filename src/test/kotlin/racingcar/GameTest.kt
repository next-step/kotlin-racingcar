package racingcar

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class GameTest : ShouldSpec({
    context("N대의 자동차를 M번 이동하는 게임이 시작되면") {
        val carNumber = 5
        val tryCount = 10
        val gameResults = Game(carNumber, tryCount).run()

        should("M개의 게임결과가 반환된다") {
            gameResults.size shouldBe tryCount
        }

        should("각 게임결과에는 N대의 자동차가 이동한 결과가 저장된다") {
            gameResults.forAll { gameResult ->
                gameResult.cars.size shouldBe carNumber
            }
        }
    }
})
