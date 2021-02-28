package step3

class OutputView {
    companion object {
        fun handleOutput(raceCount: Int, results: List<Result>) {
            println("실행 결과")
            for (i in 0 until raceCount) {
                for (result in results) {
                    println("-".repeat(result.records[i]))
                }
                println()
            }
        }
    }
}
