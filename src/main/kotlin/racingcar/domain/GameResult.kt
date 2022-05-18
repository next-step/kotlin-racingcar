package racingcar.domain

class GameResult(
    val records: List<List<Record>>
) {
    val winners = getWinnerFrom(records.last())

    private fun getWinnerFrom(gameResult: List<Record>): List<String> {
        val organizePosition = organizePosition(gameResult)
        val highestPosition = organizePosition.first
        val recordByPosition = organizePosition.second

        val winner: MutableList<String> = mutableListOf()
        val records = recordByPosition[highestPosition]

        records!!.forEach { record ->
            winner.add(record.carName)
        }

        return winner
    }

    private fun organizePosition(gameResult: List<Record>): Pair<Int, MutableMap<Int, MutableList<Record>>> {
        var highestPosition: Int? = null
        val recordsByPosition: MutableMap<Int, MutableList<Record>> = mutableMapOf()

        gameResult.forEach { record ->
            if (highestPosition == null) {
                highestPosition = record.position
                recordsByPosition[highestPosition!!] = mutableListOf(record)
                return@forEach
            }

            if (highestPosition == record.position) {
                val records = recordsByPosition[highestPosition!!]
                records!!.add(record)
                return@forEach
            }

            if (highestPosition!! < record.position) {
                highestPosition = record.position
                recordsByPosition[highestPosition!!] = mutableListOf(record)
            }
        }

        return Pair(highestPosition!!, recordsByPosition)
    }
}
