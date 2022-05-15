package raicing.view

import raicing.model.RaceCar
import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: RaceResult) {
        val outputStr = buildString {
            appendLine("========== 결과 ============")
            appendLine(raceResultOutput(raceResults))
        }
        print(outputStr)
    }

    private fun raceResultOutput(raceResults: RaceResult) = buildString {
        raceResults.raceCars.forEach { raceCar ->
            appendLine(raceResultOnceOutput(raceCar))
        }
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
