package step3

class OutputView {
    companion object {
        fun handleOutput(lapResults: LapResults) {
            println("실행 결과")

            for (lapResult in lapResults.lapResults) {
                printLapResult(lapResult)
            }
        }

        private fun printLapResult(lapResult: LapResult) {
            for (record in lapResult.records.records) {
                println("${record.name} : " + "-".repeat(record.position))
            }
            println()
        }
    }
}
