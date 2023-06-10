package racing.ui

import racing.domain.Distance
import racing.domain.RacingHistory

object RacingOutput {
    private const val SKID_MARK = "-"
    private const val SEPARATOR = ""

    fun printRacingHistories(histories: List<RacingHistory>) {
        val result = buildString {
            histories.forEach { appendSkidMarkByRound(it) }
        }

        println(result)
    }

    private fun StringBuilder.appendSkidMarkByRound(history: RacingHistory) {
        history.records.forEach {
            append("${SKID_MARK.repeat(it.value.toInt())}\n")
        }
    }
}

private fun Distance.toInt(): Int = this.toInt()
