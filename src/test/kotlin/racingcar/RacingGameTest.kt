package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({
    context("모든 차가 전진하면 항상 모든 차가 우승한다.") {
        val carNames = "홍길동,홍길순,홍길만".split(",")
        val tryNum = 5

        val racingGame = RacingGame(
            carNames,
            object : ConditionGenerator {
                override fun generate(): Int {
                    return 4
                }
            },
        )
        racingGame.start(tryNum)
        val winners = racingGame.getWinners()
        winners.size shouldBe carNames.size
    }
})
