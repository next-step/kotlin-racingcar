package raicing.view

import raicing.model.RaceCar
import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: RaceResult) {
        val outputStr = buildString {
            append("========== 결과 ============\n")
            raceResults.raceCars.forEach { raceCar ->
                appendLine(raceResultOnceOutput(raceCar))
            }
        }
        print(outputStr)
    }

    private fun raceResultOnceOutput(raceCar: RaceCar): String = buildString {
        raceCar.getCars().map { car ->
            append("${car.name}: ")
            repeat(car.position) {
                append("-")
            }
            appendLine()
        }
    }
}
