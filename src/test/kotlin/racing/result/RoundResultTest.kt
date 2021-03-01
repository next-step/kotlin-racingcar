package racing.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoundResultTest {

    @Test
    fun `라운드의 승자는 여러명이 될 수 있다`() {
        //given
        val racingHistories = listOf(
            RacingHistory("qqq", 2),
            RacingHistory("cys", 3),
            RacingHistory("www", 3)
        )
        val roundResult = RoundResult(1, racingHistories)

        //when
        val winners = roundResult.getRoundWinners()

        //then
        assertThat(winners.size).isEqualTo(2)
        assertWinner(winners, ExpectedWinner("cys", 3))
        assertWinner(winners, ExpectedWinner("www", 3))
    }

    @Test
    fun `레이싱 이력이 없으면 승자도 없다`() {
        //given
        val roundResult = RoundResult(1, listOf())

        //when
        val winners = roundResult.getRoundWinners()

        //then
        assertThat(winners.size).isEqualTo(0)
    }

    private fun assertWinner(actualList: List<Winner>, expected: ExpectedWinner) {
        val actual = actualList.find { it.name === expected.name }!!
        assertThat(actual.position).isEqualTo(expected.position)
    }

    private class ExpectedWinner(
        val name: String,
        val position: Int
    )
}