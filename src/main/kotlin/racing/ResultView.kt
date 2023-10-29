package racing

object ResultView {
    fun printRacingResult(result: CarRacingResult) {
        println("실행 결과")
        result.printRacingResults()
    }

    private fun CarRacingResult.printRacingResults() {
        results.forEach { cars ->
            cars.printRacingResultPerRound()
        }
        winners.printRacingWinner()
    }

    private fun List<Car>.printRacingResultPerRound() {
        forEach { car ->
            car.printRacingResultPerRound()
        }
        println()
    }

    private fun Car.printRacingResultPerRound() {
        println("$name : ${transformResult(position)}")
    }

    fun transformResult(position: Int): String {
        return (0 until position).map { "-" }.reduce { a, b -> a + b }
    }

    private fun List<String>.printRacingWinner() {
        println("${joinToString { it }}가 최종 우승했습니다.")
    }
}
