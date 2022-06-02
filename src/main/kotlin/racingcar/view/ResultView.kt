package racingcar.view

import racingcar.view.response.GameResult

object ResultView {
    fun printResult(gameResult: GameResult) {
        for (repsResult in gameResult.repsResults) {
            for (snapshot in repsResult.snapShots.sortedBy { it.id }) {
                for (i in 0 until snapshot.position) {
                    print("-")
                }
                println()
            }
            println()
        }
    }
}
