package racingcar.domain

import racingcar.ui.LINE_FEED

@JvmInline
value class Records private constructor(private val records: List<Record>) {

    fun display(): String {
        val result = StringBuilder()
        records.forEach { result.append(it.score).append(LINE_FEED) }
        return result.toString()
    }

    companion object {
        fun of(participants: RacingCars): Records {
            val values = participants.list.map { Record(it.position) }
            return Records(values)
        }
    }
}
