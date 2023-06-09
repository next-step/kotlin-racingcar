package racing.ui

import racing.domain.RacingHistory

object RacingOutput {
    private const val SKID_MARK = "-"
    private const val SEPARATOR = ""

    fun printRacingHistories(histories: List<RacingHistory>) {
        val stringBuilder = StringBuilder()

        histories.forEach { appendSkidMarkByRound(it, stringBuilder) }

        println(stringBuilder.toString())
    }

    private fun appendSkidMarkByRound(history: RacingHistory, stringBuilder: StringBuilder) {

        history.records.forEach {
            stringBuilder.append(
                (0 until it.value.getValue).joinToString(separator = SEPARATOR) { SKID_MARK }
            ).append("\n")
        }
    }
}
