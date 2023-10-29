package racing.view

import racing.model.RacingHistory

class OutputView {
    val render = ConsoleRender()
    fun printResults(results: ArrayDeque<RacingHistory>) {
        println("실행 결과")
        for (matchResult in results) {
            println(render.consolePresent(matchResult) + "\n")
        }
    }
}
