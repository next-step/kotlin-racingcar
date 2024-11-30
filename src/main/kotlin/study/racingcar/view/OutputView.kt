package study.racingcar.view

import study.racingcar.dto.RoundResultResponse
import study.racingcar.entity.Car
import java.util.logging.Logger
import java.util.stream.Collectors

object OutputView {
    private val logger = Logger.getLogger("OutputView")
    private const val DASHBAR_SYMBOL = "-"
    private const val COMMA = ","

    fun printRoundResults(roundResultResponses: List<RoundResultResponse>) {
        roundResultResponses.forEach { roundResultResponse -> printRoundResult(roundResultResponse.cars) }
    }

    private fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            printCarNameAndDistance(car)
        }
    }

    private fun printCarNameAndDistance(car: Car) {
        val result = DASHBAR_SYMBOL.repeat(car.currentPosition)
        logger.info { "${car.name} : $result" }
    }

    private fun printCarDistance(car: Car) {
        val result = DASHBAR_SYMBOL.repeat(car.currentPosition)
        logger.info { result }
    }

    fun printWinners(cars: List<Car>) {
        val winnerCarName = cars.stream().map { car -> car.name }.collect(Collectors.joining(COMMA))
        logger.info { "${winnerCarName}가 최종 우승했습니다." }
    }
}
