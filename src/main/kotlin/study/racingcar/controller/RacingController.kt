package study.racingcar.controller

import study.racingcar.domain.Car
import study.racingcar.domain.RaceInfo
import study.racingcar.service.RacingService
import study.racingcar.view.CarView
import study.racingcar.view.RacingView.Companion.CAR_NUMBER_MESSAGE
import study.racingcar.view.RacingView.Companion.RACE_RESULT_MESSAGE
import study.racingcar.view.RacingView.Companion.ROUND_NUMBER_MESSAGE

class RacingController(private val racingService: RacingService) {

    fun startRace() {
        val raceInfo = getRaceInfo()
        val cars = (1..raceInfo.numOfCar).map { Car("name") }

        racingService.start(raceInfo.round, cars)
        printRace()
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

    private fun getRaceInfo(): RaceInfo {
        return RaceInfo(getNumberOfCar(), getRound())
    }

    private fun getNumberOfCar(): Int {
        println(CAR_NUMBER_MESSAGE)

        val numberOfCar = readLine()!!.toInt()

        require(numberOfCar > MINIMUM_CAR)

        return numberOfCar
    }

    private fun getRound(): Int {
        println(ROUND_NUMBER_MESSAGE)

        val numberOfTry = readLine()!!.toInt()

        require(numberOfTry > MINIMUM_ROUND)

        return numberOfTry
    }

    companion object {
        private const val MINIMUM_CAR = 1
        private const val MINIMUM_ROUND = 1
    }
}
