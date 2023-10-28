package racing.view

import racing.model.MatchResult

class OutputView {
    fun printResults(results: ArrayDeque<MatchResult>) {
        println("실행 결과")
        for (matchResult in results) {
            println(matchResult.consolePresent() + "\n")
        }
    }
}
