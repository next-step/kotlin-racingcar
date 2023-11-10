package racing.view

import racing.domain.CarRacingRecord
import racing.domain.CarRacingResult

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

    private fun List<CarRacingRecord>.printRacingResultPerRound() {
        forEach { car ->
            car.printRacingResultPerRound()
        }
        println()
    }

    private fun CarRacingRecord.printRacingResultPerRound() {
        println("$name : ${transformResult(position)}")
    }

    private fun transformResult(position: Int): String {
        return (0 until position).map { "-" }.reduce { a, b -> a + b }
    }

    private fun List<String>.printRacingWinner() {
        println("${joinToString { it }}가 최종 우승했습니다.")
    }
}
