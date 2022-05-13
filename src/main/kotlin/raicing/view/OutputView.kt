package raicing.view

import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: List<RaceResult>) {
        val outputStr = buildString {
            append("========== 결과 ============\n")
            raceResults.forEach { raceResult ->
                appendLine(raceResultOnceOutput(raceResult))
            }
        }
        print(outputStr)
    }

    private fun raceResultOnceOutput(raceResult: RaceResult): String = buildString {
        raceResult.cars.map { car ->
            append("${car.id}: ")
            repeat(car.position) {
                append("-")
            }
            appendLine()
        }
    }
}
