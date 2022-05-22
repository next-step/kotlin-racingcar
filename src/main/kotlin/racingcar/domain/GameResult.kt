package racingcar.domain

import racingcar.domain.collection.RoundRecord

class GameResult(
    val records: List<RoundRecord>
) {
    val winners = getWinnerFrom(records.last())

    private fun getWinnerFrom(gameResult: RoundRecord): List<String> {
        val recordByPosition: Map<Int, RoundRecord> = groupByPosition(gameResult)
        val highestPosition = findMaxPosition(recordByPosition)

        val winner: MutableList<String> = mutableListOf()
        val records = recordByPosition[highestPosition]

        records!!.roundRecord
            .forEach { record ->
                winner.add(record.carName)
            }

        return winner
    }

    private fun groupByPosition(gameResult: RoundRecord): Map<Int, RoundRecord> {
        return gameResult.roundRecord
            .groupBy { record -> record.position }
            .mapValues { it -> RoundRecord(it.value) }
    }

    private fun findMaxPosition(recordByPosition: Map<Int, RoundRecord>): Int {
        return recordByPosition.keys
            .maxOf { position -> position }
    }
}
