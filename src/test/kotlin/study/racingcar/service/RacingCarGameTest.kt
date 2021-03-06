package study.racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource("2, 3", "2, 3")
    fun `자동차 대수와 시도 횟수에 맞게 게임이 진행되는가`(carCount: Int, tryCount: Int) {
        val game = RacingCarGame(carCount, tryCount)
        game.start()

        val raceResults = game.getRaceResults()
        assertThat(game.getRaceResults().size).isEqualTo(tryCount)
        raceResults.forEach { assertThat(it.resultSymbols.size).isEqualTo(carCount) }
    }
}
