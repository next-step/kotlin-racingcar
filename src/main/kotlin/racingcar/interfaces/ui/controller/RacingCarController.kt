package racingcar.interfaces.ui.controller

import racingcar.application.race.Race
import racingcar.application.race.RoundCarData
import racingcar.domain.car.ParticipatingCars
import racingcar.interfaces.ui.controller.console.RacingCarInputConsole
import racingcar.interfaces.ui.controller.console.RacingCarOutputConsole

class RacingCarController(
    private val race: Race
) {

    fun startRace() {
        val input = RacingCarInputConsole.input()
        val participatingCars = race.getParticipatingCars(carNames = input.carNames)

        initRace(participatingCars = participatingCars)

        processRace(participatingCars = participatingCars, attemptCount = input.attemptCount)

        winRace(participatingCars = participatingCars)
    }

    private fun initRace(participatingCars: ParticipatingCars) {
        val initRoundData = race.currentRace(participatingCars = participatingCars)
        RacingCarOutputConsole.printlnResult()
        initRoundData.printCurrent()
        RacingCarOutputConsole.printNewLine()
    }

    private fun processRace(participatingCars: ParticipatingCars, attemptCount: Int) {
        repeat(attemptCount) {
            participatingCars.move()
            val currentRoundData = race.currentRace(participatingCars = participatingCars)
            currentRoundData.printCurrent()
            RacingCarOutputConsole.printNewLine()
        }
        RacingCarOutputConsole.printNewLine()
    }

    private fun winRace(participatingCars: ParticipatingCars) {
        val winEventCarData = race.win(participatingCars)
        RacingCarOutputConsole.printPrepareWin()

        val winnerNames = mutableListOf<String>()
        winEventCarData.carData.map { winnerNames.add(it.name) }
        RacingCarOutputConsole.printWinners(winnerNames = winnerNames)
    }

    private fun RoundCarData.printCurrent() {
        this.carData.forEach {
            RacingCarOutputConsole.print(it.name)
            repeat(it.position) {
                RacingCarOutputConsole.printPosition()
            }
            RacingCarOutputConsole.printNewLine()
        }
    }
}
