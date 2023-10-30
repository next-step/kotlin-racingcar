package racing.view

import racing.model.RoundHistory

class OutputView {

    fun printResults(results: ArrayDeque<RoundHistory>) {
        println("실행 결과")
        for (matchResult in results) {
            println(ConsoleRender.consolePresent(matchResult) + "\n")
        }
    }
}
