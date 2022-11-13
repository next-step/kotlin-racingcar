package racingcar.ui

import racingcar.racingcar.CarRacingResult
import racingcar.racingcar.CarRecord
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
        println(result.results.joinToString("\n") { carRecordToView(it) })
    }

    private fun carRecordToView(carRecord: CarRecord): String {
        val distanceString = List(carRecord.distance) { LOCATION_STRING }.joinToString("")
        return "${carRecord.carName} : $distanceString"
    }

    companion object {
        const val LOCATION_STRING = "-"
    }
}
