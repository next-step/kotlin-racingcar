package study.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest: StringSpec({
    "자동차 게임을 시작하면 모든 스테이지애 대한 결과가 반환 된다." {
        // given
        val porsche = Car("Porsche", NormalEngine())
        val morning = Car("Morning", BrokenEngine())
        val racingGame = RacingGame(listOf(porsche, morning), 3)

        // when
        val racingGameResult = racingGame.start()

        // then
        racingGameResult.winners[0] shouldBe "Porsche"
        racingGameResult.racingGameStages.size shouldBe 3
    }

    "자동차 게임을 시작하면 게임의 우승자가 반환 된다." {
        // given
        val porsche = Car("Porsche", NormalEngine())
        val morning = Car("Morning", BrokenEngine())
        val racingGame = RacingGame(listOf(porsche, morning), 3)

        // when
        val racingGameResult = racingGame.start()

        // then
        racingGameResult.winners[0] shouldBe "Porsche"
    }
})
