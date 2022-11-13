package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class RacingGameTest : StringSpec() {
    init {
        "레이싱 게임은 플레이 할 수 있고 결과를 반환한다" {
            val goStrategy: MoveStrategy = object : MoveStrategy {
                override fun canMove(): Boolean = true
            }
            val racingGame = RacingGame("ko,rong", 1, goStrategy)

            val result = racingGame.play()

            result.roundResults shouldContainExactly listOf(CarInfos(listOf(
                CarInfo("ko", Position(1)),
                CarInfo("rong", Position(1))
            )))
            result.winners.winners shouldContainExactly listOf(
                CarInfo("ko", Position(1)),
                CarInfo("rong", Position(1))
            )
        }
    }
}
