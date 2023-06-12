package study.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({

    "자동차 게임을 시작하면 모든 스테이지애 대한 결과가 반환 된다." {
        // given
        val lulla = Participant("lulla")
        val bulla = Participant("bulla")

        val porsche = Car(lulla, NormalEngine(), Position())
        val morning = Car(bulla, BrokenEngine(), Position())
        val racingGame = RacingGame(listOf(porsche, morning), 3)

        // when
        val racingGameResult = racingGame.start()

        // then
        racingGameResult.racingGameStages.size shouldBe 3
    }

    "자동차 게임을 시작하면 게임의 우승자가 반환 된다." {
        // given
        val lulla = Participant("lulla")
        val bulla = Participant("bulla")

        val porsche = Car(lulla, NormalEngine(), Position())
        val morning = Car(bulla, BrokenEngine(), Position())
        val racingGame = RacingGame(listOf(porsche, morning), 3)

        // when
        val racingGameResult = racingGame.start()

        // then
        racingGameResult.winners[0] shouldBe lulla
    }
})
