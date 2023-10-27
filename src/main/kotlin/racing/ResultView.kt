package racing

object ResultView {
    fun printRacingResult(racingResults: List<List<Int>>) {
        println("실행 결과")
        racingResults.forEach { cars ->
            cars.printRacingResultPerRound()
        }
    }

    private fun List<Int>.printRacingResultPerRound() {
        forEach { position ->
            println(transformResult(position))
        }
        println()
    }

    fun transformResult(position: Int): String {
        return (0 until position).map { "-" }.reduce { a, b -> a + b }
    }
}
