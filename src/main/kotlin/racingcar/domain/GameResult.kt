package racingcar.domain

import racingcar.domain.collection.RoundRecord

class GameResult(
    val records: List<RoundRecord>
) {
    val winners = getWinnerFrom(records.last())

    private fun getWinnerFrom(gameResult: RoundRecord): List<String> {
        val roundRecordByPosition: Map<Int, RoundRecord> = groupByPosition(gameResult)
        val highestPosition = findMaxPosition(roundRecordByPosition)

        val winner: MutableList<String> = mutableListOf()
        val records = roundRecordByPosition[highestPosition]

        records!!.roundRecord
            .forEach { record ->
                winner.add(record.carName)
            }

        return winner
    }

    private fun groupByPosition(gameResult: RoundRecord): Map<Int, RoundRecord> {
        return gameResult.roundRecord
            .groupBy { record -> record.position }
            .mapValues { recordByPosition -> RoundRecord(recordByPosition.value) }
    }

    private fun findMaxPosition(recordByPosition: Map<Int, RoundRecord>): Int {
        return recordByPosition.keys
            .maxOf { position -> position }
    }
}
