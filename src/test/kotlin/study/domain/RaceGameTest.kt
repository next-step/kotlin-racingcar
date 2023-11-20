package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RaceGameTest {
    @Test
    fun `객체생성 테스트`() {
        val raceGame = RaceGame.of(carNames = listOf("name", "name2"), totalRound = 2)
        assertThat(raceGame).isEqualTo(RaceGame(listOf(RaceCar(CarName("name")), RaceCar(CarName("name2"))), 2))
    }

    @Test
    fun `자동차경주게임 시작`() {
        val players = listOf(RaceCar(CarName("name")), RaceCar(CarName("name2")))
        val raceGame = RaceGame(players, totalRound = 2, moveStrategy = fun() = true)
        val raceResult = raceGame.play()
        assertAll(
            {
                assertThat(raceResult.winners).isEqualTo(players)
            },
            {
                assertThat(raceResult.eachRoundResults).isEqualTo(
                    mutableMapOf(
                        1 to listOf(RaceCar(CarName("name"), 1), RaceCar(CarName("name2"), 1)),
                        2 to listOf(RaceCar(CarName("name"), 2), RaceCar(CarName("name2"), 2))
                    )
                )
            }
        )
    }
}
