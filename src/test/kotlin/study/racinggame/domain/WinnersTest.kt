package study.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnersTest : StringSpec({
    "참가자 중 위치가 가장 큰 참가자가 우승자가 된다." {
        // given
        val participantA = Participant("A")
        val participantB = Participant("B")

        val racingGameStages = RacingGameStage(
            1,
            listOf(
                CarPosition(participant = participantA, position = Position(2)),
                CarPosition(participant = participantB, position = Position(1)),
            )
        )

        // when
        val winners = Winners(listOf(racingGameStages))

        // then
        winners.names()[0] shouldBe "A"
    }

    "참가자 중 위치가 가장 큰 참가자가 두 명 이상이면 공동 우승 한다." {
        // given
        val participantA = Participant("A")
        val participantB = Participant("B")

        val racingGameStages = RacingGameStage(
            1,
            listOf(
                CarPosition(participant = participantA, position = Position(1)),
                CarPosition(participant = participantB, position = Position(1)),
            )
        )

        // when
        val winners = Winners(listOf(racingGameStages))

        // then
        winners.names()[0] shouldBe "A"
        winners.names()[1] shouldBe "B"
    }
})
