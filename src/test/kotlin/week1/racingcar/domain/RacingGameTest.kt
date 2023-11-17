package week1.racingcar.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `턴 진행이 잘 이루어졌는가?`() {
        val carsBeforeDriving = listOf(
            Car("1"),
            Car("2"),
            Car("3"),
            Car("4"),
        )
        val timesToRace = 2
        val racingGame = RacingGame(carsBeforeDriving, timesToRace)
        racingGame.driveOneTurn()
        racingGame.isPlaying() shouldBe true
        racingGame.driveOneTurn()
        racingGame.isPlaying() shouldBe false
    }

    @Test
    fun `우승자 찾기`() {
        val carsAfterDriving = listOf(
            Car("1", 0),
            Car("2", 10),
            Car("3", 3),
            Car("4", 7),
            Car("5", 10),
        )
        val racingGame = RacingGame(carsAfterDriving)

        val winnersByRacingGame = racingGame.filterWinners()

        assertThat(winnersByRacingGame).hasSize(2)
        assertThat(winnersByRacingGame).containsExactlyElementsOf(listOf("2", "5"))
    }

    @Test
    fun `게임 진행 가능 상태 확인`() {
        val stoppedGame = RacingGame(listOf(), 0)
        val playingGame = RacingGame(listOf(), 10)

        stoppedGame.isPlaying() shouldBe false
        playingGame.isPlaying() shouldBe true
    }

}
