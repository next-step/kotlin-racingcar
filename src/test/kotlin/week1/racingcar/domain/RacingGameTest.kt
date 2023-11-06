package week1.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `한 번의 턴 진행`() {
        val racingGame = RacingGame(carsBeforeDriving)
        racingGame.driveOneTurn().forEach {
            assert(it.currentMileage() in 0..1)
        }
    }

    @Test
    fun `우승자 찾기`() {
        val racingGame = RacingGame(carsAfterDriving)

        val winnersByRacingGame = racingGame.filterWinners()

        assertThat(winnersByRacingGame).hasSize(2)
        assertThat(winnersByRacingGame).containsExactlyElementsOf(listOf("2", "5"))
    }

    companion object {
        private val carsBeforeDriving = listOf(
            Car("1"),
            Car("2"),
            Car("3"),
            Car("4"),
        )

        private val carsAfterDriving = listOf(
            Car("1", 0),
            Car("2", 10),
            Car("3", 3),
            Car("4", 7),
            Car("5", 10),
        )
    }
}
