package race.view

import race.Record
import race.view.Message.RESULT_TITLE
import race.view.Message.WINNER_MESSAGE

class Output(
    private val resultRecord: Record
) {
    fun printResult() {
        val records = resultRecord.raceRecords
        println(RESULT_TITLE)
        val raceCount = records[records.keys.first()]!!.size
        for (currentRace in 0 until raceCount) {
            println("${currentRace + 1}번째 레이스")
            printCarMovement(records, currentRace)
        }
    }

    fun printWinner() {
        val winnerNames = resultRecord.getWinnerCarName()
        val joinedWinnerNames = winnerNames.joinToString(separator = ",")
        println("${joinedWinnerNames}$WINNER_MESSAGE")
    }

    private fun printCarMovement(
        records: HashMap<String, MutableList<Boolean>>,
        currentRace: Int
    ) {
        records.forEach { record ->
            val isMovements = record.value.slice(0 until currentRace + 1)
            val movementCount = isMovements.count { it }
            println(record.key + " : " + "-".repeat(movementCount))
        }
    }
}
