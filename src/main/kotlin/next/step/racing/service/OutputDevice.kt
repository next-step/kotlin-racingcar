package next.step.racing.service

import next.step.racing.domain.car.CarRecord
import next.step.racing.service.to.RacingResult

object OutputDevice {

    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."
    private const val RESULT_TITLE = "실행 결과"

    fun showResult(result: RacingResult) {
        showTitle()
        showAllRecords(result.records)
        showWinners(result.winners)
    }

    private fun showTitle() {
        println()
        println(RESULT_TITLE)
    }

    private fun showAllRecords(allRecords: List<List<CarRecord>>) {
        allRecords.forEach { showRecords(it) }
    }

    private fun showRecords(records: List<CarRecord>) {
        records.forEach { println("${it.name} : ${"-".repeat(it.pos)}") }
        println()
    }

    private fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
        println()
    }
}
