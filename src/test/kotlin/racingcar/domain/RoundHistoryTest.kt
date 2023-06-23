package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoundHistoryTest {
    @Test
    fun `position은 1이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            RoundHistory(
                listOf(PositionHistory("test", 0))
            )
        }
    }

    @Test
    fun `각 라운드의 우승자들을 구할 수 있다`() {
        val positionHistories: List<PositionHistory> = listOf(
            PositionHistory("test1", 1),
            PositionHistory("test2", 2),
            PositionHistory("test3", 2),
        )
        val roundHistory = RoundHistory(positionHistories)
        val winnerNames = roundHistory.getWinnerNames()

        winnerNames shouldBe listOf("test2", "test3")
    }
}
