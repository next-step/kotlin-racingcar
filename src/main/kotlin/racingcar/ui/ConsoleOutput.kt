package racingcar.ui

import racingcar.service.dto.GameResultDto

class ConsoleOutput {

    fun printGameResults(gameResults: List<GameResultDto>) {
        println("실행 결과")
        gameResults.forEach { gameResult ->
            gameResult.cars.forEach { car ->
                println("-".repeat(car.position))
            }
            println()
        }
    }
}
