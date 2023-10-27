package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceGameTest {
    @Test
    fun of() {
        val raceGame = RaceGame.of(carCount = 2, totalRound = 2)
        assertThat(raceGame).isEqualTo(RaceGame(listOf(RaceCar(), RaceCar()), 2))
    }

    @Test
    fun play() {
        val raceGame = RaceGame(listOf(RaceCar(), RaceCar()), totalRound = 2, moveStrategy = fun() = true)
        val raceResult = raceGame.play()
        assertThat(raceResult).isEqualTo(
            RaceResult(
                mutableMapOf(
                    1 to listOf(RaceCar(1), RaceCar(1)),
                    2 to listOf(RaceCar(2), RaceCar(2))
                )
            )
        )
    }
}
