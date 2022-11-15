package racingcar.domain

import java.util.Collections

class RaceResult(records: List<Record>) {
    val records: List<Record> = Collections.unmodifiableList(records.toList())

    fun finalRecords(): List<Record> {
        val finalRound = records.maxOf { it.round }

        return records.filter { it.round == finalRound }
    }
}
