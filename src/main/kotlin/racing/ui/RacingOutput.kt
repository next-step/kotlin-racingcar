package racing.ui

import racing.domain.Distance
import racing.domain.Name
import racing.domain.RacingHistory
import racing.domain.RacingResult

object RacingOutput {
    private const val SKID_MARK = "-"
    private const val SEPARATOR = ""

    fun printRacingResult(racingResult: RacingResult) {
        printRacingHistories(racingResult.racingHistories)
        printRacingWinners(racingResult.winners)
    }

    fun printRacingHistories(histories: List<RacingHistory>) {
        val result = buildString {
            histories.forEach { appendSkidMarkByRound(it) }
        }

        println(result)
    }

    private fun StringBuilder.appendSkidMarkByRound(history: RacingHistory) {
        history.records.forEach {
            append("${it.key} : ${SKID_MARK.repeat(it.value.toInt())}\n")
        }

        append("\n")
    }

    fun printRacingWinners(winners: List<Name>) {
        val result = winners.joinToString(separator = ",")

        println("$result 가 최종 우승했습니다")
    }
}

private fun Distance.toInt(): Int = this.value.toInt()
