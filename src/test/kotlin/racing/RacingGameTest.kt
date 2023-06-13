package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({

    "경주 결과는 시도횟수만큼 생긴다." {
        val racingGame = RacingGame(cars())

        val raceResult: List<Cars> = racingGame.race(tryCount = 2, movePolicy = { true })

        raceResult shouldHaveSize 2
    }

    "경주 결과는 자동차 경주 결과를 반환한다" {
        val racingGame = RacingGame(cars())

        val raceResult: List<Cars> = racingGame.race(tryCount = 2, movePolicy = { true })

        val lastCars = raceResult.last()
        lastCars[0].position shouldBe 3
        lastCars[1].position shouldBe 6
        lastCars[2].position shouldBe 6
    }
})
