package next.step.racing.service

import next.step.racing.domain.car.CarRecord
import next.step.racing.service.to.RacingResult

object OutputDevice {

    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."
    private const val RESULT_TITLE = "실행 결과"

    fun showResult(result: RacingResult) {
        showTitle()
        showRecords(result.records)
        showWinners(result.winners)
    }

    private fun showTitle() {
        println()
        println(RESULT_TITLE)
    }

    private fun showRecords(allRecords: List<List<CarRecord>>) {
        for (records in allRecords) {
            for (record in records) {
                println("${record.name} : ${"-".repeat(record.pos)}")
            }
            println()
        }
    }

    private fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
    }
}
