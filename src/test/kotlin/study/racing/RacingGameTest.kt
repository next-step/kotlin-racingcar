package study.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeUUID
import racing.domain.RacingGame
import racing.enumeration.RacingGameStatus
import racing.factory.RacingCarFactory

class RacingGameTest : StringSpec({
    "참가 대수 3대 5 round 게임을 준비 상태로 생성한다." {
        val participants = RacingCarFactory.create(3)
        val game = RacingGame.create(participants, 5)

        game.id.value.shouldBeUUID()
        game.participants.size shouldBe 3
        game.round shouldBe 5
        game.status shouldBe RacingGameStatus.READY
    }

    "참가 대수 3대 5 round 게임을 실행한다." {
        val participants = RacingCarFactory.create(3)
        val game = RacingGame.create(participants, 5)

        game.play()
        game.status shouldBe RacingGameStatus.FINISH
    }

    "이미 완료된 게임은 시작할 수 없다." {
        val participants = RacingCarFactory.create(3)
        val game = RacingGame.create(participants, 5)

        game.play()
        shouldThrow<IllegalStateException> {
            game.play()
        }
    }
})
