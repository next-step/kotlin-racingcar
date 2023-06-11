package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.RacingCarDriveResult
import racingcar.domain.RacingCarGameWinnerFinder
import racingcar.domain.RacingCarRoundResult

class RacingCarGameWinnerFinderTest {

    @Test
    fun `check winner names`() {
        val lastRound: Long = 5
        val winnerName = "austin"
        val winnerPosition = 10
        val carNames = listOf(winnerName, "b", "c")

        val carDriveResults = carNames.map {
            RacingCarDriveResult(
                carNumber = 1,
                position = (if (it == winnerName) winnerPosition else winnerPosition - 1).toLong(),
                carName = it
            )
        }

        val gameRoundResults = listOf(RacingCarRoundResult(round = lastRound, carDriveResults = carDriveResults))

        val result =
            RacingCarGameWinnerFinder.findWinnerNames(gameRoundResults = gameRoundResults, lastRound = lastRound)

        assertThat(result).isEqualTo(listOf(winnerName))
    }
}
