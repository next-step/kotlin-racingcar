package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RoundHistoryTest {
    @Test
    fun `position은 1이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            RoundHistory(
                listOf(PositionHistory(CarName("test"), Position(0)))
            )
        }
    }

    @Test
    fun `각 라운드의 우승자들을 구할 수 있다`() {
        val positionHistories: List<PositionHistory> = listOf(
            PositionHistory(CarName("test1"), Position(1)),
            PositionHistory(CarName("test2"), Position(2)),
            PositionHistory(CarName("test3"), Position(2)),
        )
        val roundHistory = RoundHistory(positionHistories)
        val winnerNames = roundHistory.getWinnerNames()

        winnerNames.value.map { it.value } shouldBe listOf("test2", "test3")
    }
}
