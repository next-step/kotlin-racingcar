package racingcar.ui

import racingcar.application.GameResult

object ResultView {

    fun show(gameResult: GameResult) {
        gameResult.racingRecords.run {
            forEach {
                println("[${it.phase}번째 진행]")
                it.carStates.forEach { car ->
                    repeat(car.currentPosition) {
                        print("-")
                    }
                    println()
                }
            }
        }
    }
}
