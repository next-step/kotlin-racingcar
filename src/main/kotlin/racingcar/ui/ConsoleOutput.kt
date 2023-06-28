package racingcar.ui

import racingcar.service.dto.GameResultDto

object ConsoleOutput {

    fun printGameResults(gameResults: List<GameResultDto>) {
        println("실행 결과")
        gameResults.forEach { gameResult ->
            gameResult.cars.forEach { car ->
                println("${car.name}: ${"-".repeat(car.position)}")
            }
            println()
        }
    }
}
