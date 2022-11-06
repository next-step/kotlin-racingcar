package nexstep.mission.racingcar

import nexstep.mission.racingcar.io.Input
import java.util.Random

class RacingCarController(
    private val input: Input
) {

    fun race() {
        val racingCarCount = input.inputRacingCars()
        val racingGame = RacingGame(racingCarCount)
        val round = input.inputRound()
        startRace(round, racingGame)
    }

    private tailrec fun startRace(round: Int, racingGame: RacingGame): Unit =
        when (true) {
            (round == 0) -> Unit
            else -> {
                racingGame.race { Random().nextInt(10) }
                startRace(round - 1, racingGame)
            }
        }
}
