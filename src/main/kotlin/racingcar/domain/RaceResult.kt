package racingcar.domain

class RaceResult(records: List<Record>) {
    val records: List<Record> = records.toList()

    fun finalRecords(): List<Record> {
        val finalRound = records.maxOf { it.round }

        return records.filter { it.round == finalRound }
    }
}
