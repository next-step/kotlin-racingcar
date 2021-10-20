package racingcar.domain

import racingcar.ui.LINE_FEED
import java.lang.StringBuilder

class Records {
    private val records = mutableListOf<Record>()

    constructor(participants: RacingCars) {
        participants.list.forEach { records.add(Record(it.position)) }
    }

    fun display(): String {
        val result = StringBuilder()
        records.forEach { result.append(it.score).append(LINE_FEED) }
        return result.toString()
    }
}
