package racing.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameResultTest {

    @Test
    fun `게임 결과에서 최종 라운드의 승자를 찾을 수 있다`() {
        //given
        val roundOneResult = RoundResult(
            1, listOf(
                RacingHistory("qqq", 2),
                RacingHistory("cys", 1),
                RacingHistory("www", 3)
            )
        )

        val roundTwoResult = RoundResult(
            2, listOf(
                RacingHistory("qqq", 3),
                RacingHistory("cys", 5),
                RacingHistory("www", 4)
            )
        )

        val gameResult = GameResult(listOf(roundOneResult, roundTwoResult))

        //when
        val winners = gameResult.getWinners()

        //then
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].round).isEqualTo(2)
        assertThat(winners[0].name).isEqualTo("cys")
        assertThat(winners[0].position).isEqualTo(5)
    }

    @Test
    fun `라운드 결과가 없을 시 최종 승자도 없다`() {
        //given
        val gameResult = GameResult(listOf())

        //when
        val winners = gameResult.getWinners()

        //then
        assertThat(winners.size).isEqualTo(0)
    }
}