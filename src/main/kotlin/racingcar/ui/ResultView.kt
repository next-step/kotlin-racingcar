package racingcar.ui

import racingcar.racingcar.CarRacingResult
import racingcar.racingcar.TurnRecord

class ResultView {
    fun view(carRacingResult: CarRacingResult) {
        println("[자동차 경주 결과]")
        val results = carRacingResult.getAll()
        results.forEach { result ->
            printResult(result)
        }
    }

    private fun printResult(result: TurnRecord) {
        println("${result.turn} 회")
        println(result.results.joinToString("\n") { locationToView(it) })
    }

    private fun locationToView(location: Int): String {
        return List(location) { LOCATION_STRING }.joinToString("")
    }

    companion object {
        const val LOCATION_STRING = "-"
    }
}
