package step3

class OutputView {
    companion object {
        fun handleOutput(lapCount: Int, lapResults: List<LapResult>) {
            println("실행 결과")
            println(lapResults)
            repeat(lapCount) {
                printRace(lapResults, it)
            }
        }

        private fun printRace(lapResults: List<LapResult>, lap: Int) {
            for (lapResult in lapResults) {
                println("-".repeat(lapResult.records[lap]))
            }
            println()
        }
    }
}
