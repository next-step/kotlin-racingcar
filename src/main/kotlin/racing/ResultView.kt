package racing

object ResultView {
    fun printRacingResult(racingResults: List<List<Car>>) {
        println("실행 결과")
        racingResults.forEach { cars ->
            cars.printRacingResultPerRound()
        }
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
}
