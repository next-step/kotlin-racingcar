package study.racingcar.controller

import study.racingcar.domain.Car
import study.racingcar.domain.RaceInfo
import study.racingcar.service.RacingService
import study.racingcar.view.CarView

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
                println(CarView(it).position)
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
        private const val CAR_NUMBER_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val ROUND_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val RACE_RESULT_MESSAGE = "실행 결과"
        private const val MINIMUM_CAR = 1
        private const val MINIMUM_ROUND = 1
    }
}
