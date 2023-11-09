package racingcar

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingGame

class RacingGameTest : ShouldSpec({
    context("N대의 자동차를 M번 이동하는 게임이 시작되면") {
        val carNames = listOf("pobi", "crong", "honux")
        val tryCount = 10
        val racingGameResults = RacingGame(carNames, tryCount).run()

        should("M개의 게임결과가 반환된다") {
            racingGameResults.size shouldBe tryCount
        }

        should("각 게임결과에는 N대의 자동차가 이동한 결과가 저장된다") {
            racingGameResults.forAll { gameResult ->
                gameResult.cars.size shouldBe carNames.size
            }
        }
    }
})
