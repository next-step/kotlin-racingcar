package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.fixture.ALWAYS_MOVING_STRATEGY
import racingcar.fixture.NEVER_MOVING_STRATEGY

class RacingGameTest {

    @Test
    fun `레이싱 게임을 실행하면 라운드별로 결과를 기록한다`() {
        val carNames = "a,b,c"
        val round = 5
        val racingGame = RacingGame(round, carNames, NEVER_MOVING_STRATEGY)
        racingGame.run()

        val histories = racingGame.getHistories()

        histories shouldBe List(round) { createRoundHistory(it, carNames.split(",")) }
    }

    @Test
    fun `레이싱 게임을 실행하면 우승자를 알 수 있다`() {
        val carNames = "a,b,c"
        val round = 5
        val racingGame = RacingGame(round, carNames, ALWAYS_MOVING_STRATEGY)
        racingGame.run()

        val winners = racingGame.getWinnerNames()

        winners shouldBe listOf("a", "b", "c")
    }

    private fun createRoundHistory(it: Int, names: List<String>) =
        RoundHistory(it, List(names.size) { CarInfo(names[it], 0) })
}
