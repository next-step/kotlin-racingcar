package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceGameTest {
    @Test
    fun `객체생성 테스트`() {
        val raceGame = RaceGame.of(carCount = 2, carNames = listOf("name", "name2"), totalRound = 2)
        assertThat(raceGame).isEqualTo(RaceGame(listOf(RaceCar("name"), RaceCar("name2")), 2))
    }

    @Test
    fun `자동차경주게임 시작`() {
        val players = listOf(RaceCar("name"), RaceCar("name2"))
        val raceGame = RaceGame(players, totalRound = 2, moveStrategy = fun() = true)
        val raceResult = raceGame.play()
        assertThat(raceResult).isEqualTo(
            RaceResult(
                winners = players,
                result = mutableMapOf(
                    1 to listOf(RaceCar("name", 1), RaceCar("name2", 1)),
                    2 to listOf(RaceCar("name", 2), RaceCar("name2", 2))
                )
            )
        )
    }
}
