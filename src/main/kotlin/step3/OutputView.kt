package step3

class OutputView {
    companion object {
        fun handleOutput(raceCount: Int, results: List<Result>) {
            println("실행 결과")
            repeat(raceCount) {
                printRace(results, it)
            }
        }

        private fun printRace(results: List<Result>, lap: Int) {
            for (result in results) {
                println("-".repeat(result.records[lap]))
            }
            println()
        }
    }
}
