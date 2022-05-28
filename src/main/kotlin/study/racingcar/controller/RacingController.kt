package study.racingcar.controller

import study.racingcar.domain.Car
import study.racingcar.domain.RaceInfo
import study.racingcar.service.RacingService
import study.racingcar.view.CarView
import study.racingcar.view.RacingView.Companion.CAR_NAME_INPUT_MESSAGE
import study.racingcar.view.RacingView.Companion.RACE_RESULT_MESSAGE
import study.racingcar.view.RacingView.Companion.RACING_WINNER_MESSAGE
import study.racingcar.view.RacingView.Companion.ROUND_NUMBER_MESSAGE

class RacingController(private val racingService: RacingService) {

    fun startRace() {
        val raceInfo = getRaceInfo()
        val cars = raceInfo.carNames.map { Car(it) }

        racingService.start(raceInfo.round, cars)
        printRace()
        printWinner()
    }

    private fun printRace() {
        println(RACE_RESULT_MESSAGE)
        racingService.getAllRounds().forEach { round ->
            round.cars.forEach {
                println(CarView(it).result)
            }
            println()
        }
    }

    private fun printWinner() {
        val winners = racingService.getLastRound().winners()
        println(RACING_WINNER_MESSAGE(winners.joinToString(", ") { it.name }))
    }

    private fun getRaceInfo(): RaceInfo {
        return RaceInfo(getNamesOfCar(), getRound())
    }

    private fun getNamesOfCar(): List<String> {
        println(CAR_NAME_INPUT_MESSAGE)

        val names = readLine()!!.split(",")

        require(names.size >= MINIMUM_CAR)

        return names
    }

    private fun getRound(): Int {
        println(ROUND_NUMBER_MESSAGE)

        val numberOfTry = readLine()!!.toInt()

        require(numberOfTry >= MINIMUM_ROUND)

        return numberOfTry
    }

    companion object {
        private const val MINIMUM_CAR = 1
        private const val MINIMUM_ROUND = 1
    }
}
