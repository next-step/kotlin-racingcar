package nexstep.mission.racingcar

import nexstep.mission.racingcar.io.Input
import nexstep.mission.racingcar.io.Output
import nexstep.mission.racingcar.io.RacingCarDto
import java.util.Random

private val RANDOM = Random()

private const val NUMBER_UNDER_TEN = 10

class RacingCarController(
    private val input: Input,
    private val output: Output
) {

    fun race() {
        val racingCarNames = input.inputRacingCarNames()
        val racingGame = RacingGame(racingCarNames)
        val round = input.inputRound()
        startRace(round, racingGame)
        val winners = racingGame.winner()
        output.printWinner(winners.map { it.name.value })
    }

    private tailrec fun startRace(round: Int, racingGame: RacingGame): Unit =
        when {
            (round == 0) -> Unit
            else -> {
                racingGame.race { RANDOM.nextInt(NUMBER_UNDER_TEN) }
                output.printPositions(racingGame.racingCars.map { RacingCarDto(it.name.value, it.position) })
                startRace(round - 1, racingGame)
            }
        }
}
