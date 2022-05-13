package raicing.view

import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResults: List<RaceResult>) {
        val sb = StringBuilder("========== 결과 ============\n")

        raceResults.forEach { raceResult ->
            raceResult.cars.map { car ->
                sb.append("${car.id}: ")
                repeat(car.position) {
                    sb.append("-")
                }
                sb.appendLine()
            }
            sb.appendLine()
        }
        print(sb)
    }
}
