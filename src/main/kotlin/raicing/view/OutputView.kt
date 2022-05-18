package raicing.view

import raicing.model.RaceCar
import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: RaceResult) {
        val outputStr = buildString {
            appendLine("========== 결과 ============")
            appendLine(raceResultOutput(raceResults))
            appendLine(raceWinnerStr(raceResults))
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

    private fun raceWinnerStr(raceResults: RaceResult): String {
        val winners = raceResults.whoIsWinner()?.joinToString(", ") { it.name }
        return if (winners.isNullOrEmpty()) {
            "우승자는 없습니다."
        } else {
            "${winners}가 최종 우승했습니다."
        }
    }
}
