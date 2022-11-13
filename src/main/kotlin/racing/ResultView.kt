package racing

import racing.model.RacingResult

object ResultView {
    private const val CAR_MILEAGE_INDICATOR = "-"

    fun printRaceResult(results: List<RacingResult>) {
        println("실행 결과")
        results.forEach { racingResult ->
            printRoundRaceResult(racingResult)
            println()
        }
    }

    private fun printRoundRaceResult(racingResult: RacingResult) =
        racingResult.result
            .forEach {
                println(CAR_MILEAGE_INDICATOR.repeat(it.mileage))
            }
}
