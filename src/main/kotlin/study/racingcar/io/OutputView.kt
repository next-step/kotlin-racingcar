package study.racingcar.io

import study.racingcar.racing.Result

object OutputView {
    fun showResult(Results: List<Result>) {
        Results.forEach { result: Result ->
            printLineByResult(result)
        }
        printEndOfTurn()
    }

    private fun printLineByResult(result: Result) {
        val builder = StringBuilder()
        builder.append(result.name)
            .append(" : ")
            .append("-".repeat(result.location))

        return println(builder.toString())
    }

    private fun printEndOfTurn() {
        return println()
    }
}
