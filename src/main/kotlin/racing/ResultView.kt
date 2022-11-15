package racing

import racing.model.CarName
import racing.model.RacingResult

object ResultView {
    private const val CAR_MILEAGE_INDICATOR = "-"

    fun printRaceResult(results: List<RacingResult>, winners: List<CarName>) {
        println("실행 결과")
        results.forEach { racingResult ->
            printRoundRaceResult(racingResult)
            println()
        }
        printWinners(winners)
    }

    private fun printRoundRaceResult(racingResult: RacingResult) =
        racingResult.result
            .forEach { println("${it.carName.name} : ${CAR_MILEAGE_INDICATOR.repeat(it.mileage)}") }

    private fun printWinners(winners: List<CarName>) {
        println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }
}
