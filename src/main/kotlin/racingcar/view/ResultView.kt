package racingcar.view

import racingcar.view.response.GameResult

object ResultView {
    fun printResult(gameResult: GameResult) {
        for (repsResult in gameResult.repsResults) {
            for (snapshot in repsResult.snapShots) {
                print("${snapshot.name}: ")
                for (i in 0 until snapshot.position) {
                    print("-")
                }
                println()
            }
            println()
        }
        println("${gameResult.winners.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
