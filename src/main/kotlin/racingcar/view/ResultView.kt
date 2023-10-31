package racingcar.view

import racingcar.domain.Car
import racingcar.dto.CarsDto
import racingcar.dto.RacingCarResult

object ResultView {

    private const val HYPHEN = "-"
    private const val RESULT = "실행 결과"
    private const val SEMICOLON = " : "

    fun printResult(racingCarResult: RacingCarResult) {
        val carsList = racingCarResult.carsList
        val winners = racingCarResult.winners
        println(RESULT)
        printCarsResult(carsList)
        printWinner(winners)
    }

    private fun printCarsResult(cars: List<CarsDto>) {
        cars.forEach {
            printCarResult(it.cars)
            println()
        }
    }

    private fun printCarResult(cars: List<Car>) {
        cars.forEach {
            println(print(it))
        }
    }

    private fun print(car: Car): String {
        return car.name + SEMICOLON + HYPHEN.repeat(car.position)
    }

    private fun printWinner(winners: List<String>) {
        println(winners.joinToString(",") + "가 최종 우승했습니다.")
    }
}
