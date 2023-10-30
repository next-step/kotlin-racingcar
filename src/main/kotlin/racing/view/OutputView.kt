package racing.view

import racing.model.RacingHistory

class OutputView {

    fun printResults(results: ArrayDeque<RacingHistory>) {
        println("실행 결과")
        for (matchResult in results) {
            println(ConsoleRender.consolePresent(matchResult) + "\n")
        }
    }
}
