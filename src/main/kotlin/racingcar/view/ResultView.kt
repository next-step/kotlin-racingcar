package racingcar.view

import racingcar.domain.carRacing.Car
import racingcar.domain.carRacing.dto.CarRacingResult
import racingcar.domain.carRacing.dto.CarRecord
import racingcar.domain.carRacing.dto.TurnRecord

class ResultView {
    fun view(carRacingResult: CarRacingResult) {
        println("[자동차 경주 결과]")
        val results = carRacingResult.records
        results.forEach { result ->
            printTurnResult(result)
        }
        printBlank()
        printWinners(carRacingResult.winners)
    }

    private fun printTurnResult(result: TurnRecord) {
        println("${result.turn} 회")
        println(result.results.joinToString("\n") { carRecordToView(it) })
    }

    private fun printBlank() {
        println()
    }

    private fun printWinners(winners: List<Car>) {
        val winnersName = winners.map { it.name }.joinToString()
        println("${winnersName}가 최종 우승했습니다.")
    }

    private fun carRecordToView(carRecord: CarRecord): String {
        val distanceString = List(carRecord.distance) { LOCATION_STRING }.joinToString("")
        return "${carRecord.car.name} : $distanceString"
    }

    companion object {
        const val LOCATION_STRING = "-"
    }
}
