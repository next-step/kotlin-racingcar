package study.racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import study.racingcar.domain.Car
import study.racingcar.domain.Winners
import study.racingcar.ui.InputView

internal class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource("'test1,test2,test3', 3", "'test1,test2,test3', 5")
    fun `자동차 대수와 시도 횟수에 맞게 게임이 진행되는가`(carNames: String, tryCount: Int) {
        val carNameList = InputView.toCarNameList(carNames)
        val game = RacingCarGame(carNameList)
        val raceResults = game.start(tryCount)

        assertThat(raceResults.raceResultCars.size).isEqualTo(tryCount)
        raceResults.raceResultCars.forEach { assertThat(it.racedCars.size).isEqualTo(carNameList.size) }
    }

    @Test
    fun `우승자`() {
        val cars = listOf(
            Car("test1").apply {
                this.move(5)
                this.move(5)
                this.move(7)
                this.move(9)
            },
            Car("test2").apply {
                this.move(5)
            },
            Car("test3").apply {
                this.move(5)
                this.move(5)
                this.move(5)
                this.move(5)
            }
        )

        val winners = Winners(cars).winners!!

        assertThat(winners.size).isEqualTo(2)
        assertThat(winners[0].carName).isEqualTo("test1")
        assertThat(winners[1].carName).isEqualTo("test3")
    }
}
