package racing.view

import racing.model.MatchResult

class OutputView {
    val render = ConsoleRender()
    fun printResults(results: ArrayDeque<MatchResult>) {
        println("실행 결과")
        for (matchResult in results) {
            println(render.consolePresent(matchResult) + "\n")
        }
    }
}
