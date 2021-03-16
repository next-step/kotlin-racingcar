package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임을 실행하면 수행 개수만큼의 이력이 남는다.")
    fun runRaceTryCount() {
        val runRace = RacingGame(10, 5).runRace()
        assertThat(runRace.size).isEqualTo(10)
    }

    @Test
    @DisplayName("레이싱 게임을 실행하면 하나의 액션당 Car의 개수만큼의 이력이 남는다")
    fun runRaceNumberOfCar() {
        val runRace = RacingGame(10, 5).runRace()
        assertThat(runRace[0].racingActionHistories.size).isEqualTo(5)
    }
}
