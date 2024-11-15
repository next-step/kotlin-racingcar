package racing

class ConsoleResultView : ResultView {
    override fun showResult(result: RaceResult) {
        println(MESSAGE)

        result.getResults()
            .groupBy(Result::round)
            .forEach { (_, results) -> renderResults(results) }
    }

    private fun renderResults(results: List<Result>) {
        results.map(Result::position)
            .forEach(::printMark)
        println()
    }

    private fun printMark(position: Int) {
        println(MARK.repeat(position))
    }

    companion object {
        const val MESSAGE = "실행 결과"
        const val MARK = "-"
    }
}
