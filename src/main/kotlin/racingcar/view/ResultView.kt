package racingcar.view

import racingcar.RacingGame

object ResultView {
    fun printResult(game: RacingGame) {
        println("\n실행 결과")

        repeat(game.tryCount) { idx ->
            game.drivers.forEach { driver ->
                println("${driver.name} : ${"-".repeat(driver.driveRecord[idx + 1])}")
            }
            println("")
        }

        println("${game.getWinner().joinToString(", ")} 가(이) 최종 우승했습니다.")
    }
}
