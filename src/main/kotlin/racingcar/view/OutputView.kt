package racingcar.view

import racingcar.RaceResult

object OutputView {
    fun printResult(results: List<RaceResult>) {
        results.forEach { result ->
            result.cars.forEach {
                println("${it.name}: ${"-".repeat(it.position)}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("🏆 Winners: ${winners.joinToString(", ")} 🏆")
    }
}
