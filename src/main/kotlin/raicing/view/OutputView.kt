package raicing.view

import raicing.model.RaceResult

object OutputView {
    fun resultOutput(raceResultList: List<RaceResult>) {
        val sb = StringBuilder("========== 결과 ============\n")

        raceResultList.forEach { raceResult ->
            raceResult.carList.map { car ->
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
