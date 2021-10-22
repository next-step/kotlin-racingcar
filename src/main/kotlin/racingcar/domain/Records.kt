package racingcar.domain

import racingcar.ui.LINE_FEED

@JvmInline
value class Records private constructor(private val records: List<Record>) {

    fun display(): String {
        return records.joinToString(LINE_FEED) { it.score }
    }

    companion object {
        fun of(participants: RacingCars): Records {
            val values = participants.list.map { Record(it) }
            return Records(values)
        }
    }
}
