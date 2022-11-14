package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racing.domain.RacingGame
import racing.domain.Round
import racing.dto.RoundInfo

class RacingGameTest : StringSpec({
    "참가 대수 3대 1 round 게임을 생성한다." {
        val game = RacingGame.create(3, 1)
        game.participants.size shouldBe 3
        game.rounds.size shouldBe 1
    }

    "참가 대수 3대 1 round 게임을 실행한다." {
        val game = RacingGame.create(3, 1)

        mockk<Round> {
            every { race() } returns RoundInfo(
                round = 1,
                carInfos = listOf(
                    mockk {
                        every { position } returns 2
                    },
                    mockk {
                        every { position } returns 2
                    },
                    mockk {
                        every { position } returns 2
                    }
                )
            )

            val roundGameInfo = game.play()
            roundGameInfo.roundInfos.size shouldBe 1
            roundGameInfo.roundInfos.forEach {
                it.round shouldBe 1
                it.carInfos.size shouldBe 3
            }
        }
    }
})
