package step3

class OutputView {
    companion object {
        fun handleOutput(lapCount: Int, lapResults: LapResults) {
            println("실행 결과")
            println(lapResults)
            repeat(lapCount) {
                printRace(lapResults, it)
            }
        }

        private fun printRace(lapResults: LapResults, lap: Int) {
            for (lapResult in lapResults.lapResults) {
                println("-".repeat(lapResult.records[lap]))
            }
            println()
        }
    }
}
