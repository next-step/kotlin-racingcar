package race.view

import race.Record
import race.SnapShot
import race.view.Message.WINNER_MESSAGE

object Output {

    fun printResult(record: Record) {
        record.raceRecords.forEach { printSnapShot(it) }
    }

    fun printWinner(record: Record) {
        val winnerNames = record.getWinnerCarName()
        val joinedWinnerNames = winnerNames.joinToString(separator = ",")
        println("${joinedWinnerNames}$WINNER_MESSAGE")
    }

    private fun printSnapShot(snapShot: SnapShot) {
        println("${snapShot.round + 1} 번째 레이스")
        snapShot.carNames.forEachIndexed { index, name ->
            println(name + " : " + "-".repeat(snapShot.carMovements[index].count { it }))
        }
    }
}
