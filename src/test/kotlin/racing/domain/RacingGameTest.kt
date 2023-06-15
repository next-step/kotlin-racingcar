package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({

    "경주 결과는 시도횟수만큼 생긴다." {
        val cars = Cars(
            listOf(
                Car(name = "name1", position = 1),
                Car(name = "name2", position = 4),
                Car(name = "name3", position = 4),
            )
        )
        val racingGame = RacingGame(cars, tryCount = 2)

        val raceResult: List<Cars> = racingGame.race(movePolicy = { true })

        raceResult shouldHaveSize 2
    }

    "경주 결과는 자동차 경주 결과를 반환한다" {
        val cars = Cars(
            listOf(
                Car(name = "name1", position = 1),
                Car(name = "name2", position = 4),
                Car(name = "name3", position = 4),
            )
        )
        val racingGame = RacingGame(cars, tryCount = 2)

        val raceResult: List<Cars> = racingGame.race(movePolicy = { true })

        raceResult[0][0].position shouldBe 2
        raceResult[0][1].position shouldBe 5
        raceResult[0][2].position shouldBe 5
        raceResult[1][0].position shouldBe 3
        raceResult[1][1].position shouldBe 6
        raceResult[1][2].position shouldBe 6
    }
})
