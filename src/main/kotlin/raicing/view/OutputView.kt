package raicing.view

import raicing.model.RaceCar
import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: RaceResult) {
        val outputStr = buildString {
            appendLine("========== 결과 ============")
            appendLine(raceResultOutput(raceResults))
            appendLine("${getRaceWinnerName(raceResults)}가 최종 우승했습니다.")
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

    private fun getRaceWinnerName(raceResults: RaceResult): String =
        raceResults.whoIsWinner().joinToString(", ") { it.name }
}
