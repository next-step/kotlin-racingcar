package racingcar.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingGameHistoryTest {

    @Test
    fun `우승자는 포지션이 가장 큰 자동차이다`() {
        val racingGameHistory = RacingGameHistory()
        val carInfos = listOf(
            CarInfo("a", 0),
            CarInfo("b", 1),
            CarInfo("c", 2),
        )
        val roundHistory = RoundHistory(0, carInfos)
        racingGameHistory.addHistory(roundHistory)

        val winnerNames = racingGameHistory.getWinnerNames()

        winnerNames shouldBe listOf("c")
    }

    @Test
    fun `우승자는 여러명일 수 있다`() {
        val racingGameHistory = RacingGameHistory()
        val carInfos = listOf(
            CarInfo("a", 0),
            CarInfo("b", 1),
            CarInfo("c", 1),
        )
        val roundHistory = RoundHistory(0, carInfos)
        racingGameHistory.addHistory(roundHistory)

        val winnerNames = racingGameHistory.getWinnerNames()

        winnerNames shouldBe listOf("b", "c")
    }
}
