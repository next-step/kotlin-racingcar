package study.racingcar.controller

import study.racingcar.domain.Car
import study.racingcar.domain.RaceInfo
import study.racingcar.service.RacingService
import study.racingcar.view.RacingView
import study.racingcar.view.RoundView

class RacingController(private val racingService: RacingService) {

    fun startRace() {
        val raceInfo = getRaceInfo()
        val cars = raceInfo.carNames.map { Car(it) }

        racingService.start(raceInfo.round, cars)
        RacingView.printRacingStart()
        printRace()
        printWinners()
    }

    private fun printRace() {
        racingService.getAllRounds().forEach { round ->
            RoundView(round).printRoundResult()
        }
    }

    private fun printWinners() {
        RoundView(racingService.getLastRound()).printWinners()
    }

    private fun getRaceInfo(): RaceInfo {
        return RaceInfo(getNamesOfCar(), getRound())
    }

    private fun getNamesOfCar(): List<String> {
        RacingView.printCarNameInputMessage()

        val names = readLine()!!.split(",")

        require(names.size >= MINIMUM_CAR)

        return names
    }

    private fun getRound(): Int {
        RacingView.printRoundNumberMessage()

        val numberOfTry = readLine()!!.toInt()

        require(numberOfTry >= MINIMUM_ROUND)

        return numberOfTry
    }

    companion object {
        private const val MINIMUM_CAR = 1
        private const val MINIMUM_ROUND = 1
    }
}
