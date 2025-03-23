package racingcar.view

import racingcar.RaceResult

object OutputView {
    fun printResult(results: List<RaceResult>) {
        results.forEach { result ->
            result.names.zip(result.positions).forEach { (name, position) ->
                println("$name: ${"-".repeat(position)}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("🏆 Winners: ${winners.joinToString(", ")} 🏆")
    }
}
