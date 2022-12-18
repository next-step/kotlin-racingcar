package racingcar.interfaces.ui.controller

import racingcar.application.race.CarData
import racingcar.application.race.Race
import racingcar.application.race.WinCarData
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
        val initRoundData = race.currentCarPositions(participatingCars = participatingCars)
        RacingCarOutputConsole.initRace(initRoundData)
    }

    private fun processRace(participatingCars: ParticipatingCars, attemptCount: Int) {
        repeat(attemptCount) {
            participatingCars.move()
            val currentRoundData = race.currentCarPositions(participatingCars = participatingCars)
            RacingCarOutputConsole.printCurrentData(currentRoundData)
        }
    }

    private fun winRace(participatingCars: ParticipatingCars) {
        val winners = race.winners(participatingCars)

        val winnerNames = winners.announceWinners().carData.map { it.name }
        RacingCarOutputConsole.printWinners(winnerNames = winnerNames)
    }

    private fun List<Pair<String, Int>>.announceWinners(): WinCarData {
        return WinCarData(
            this.map {
                CarData(name = it.first, position = it.second)
            }
        )
    }
}
