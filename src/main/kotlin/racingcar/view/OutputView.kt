package racingcar.view

import racingcar.RaceResult

object OutputView {
    fun printResult(results: List<RaceResult>) {
        results.forEach { result ->
            result.positions.forEach {
                println("-".repeat(it))
            }
            println()
        }
    }
}
