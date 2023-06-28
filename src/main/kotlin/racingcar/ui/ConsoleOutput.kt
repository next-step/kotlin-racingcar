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

    fun printWinners(winners: List<String>) {
        println("${winners.joinToString(",")} 가 최종 우승했습니다.")
    }
}
