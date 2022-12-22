package race.view

import race.Record
import race.SnapShot
import race.view.Message.WINNER_MESSAGE

object Output {

    fun printResult(record: Record) {
        repeat(record.lastRound + 1) { round ->
            val snapShots = record.getSnapshotsByRound(round)
            printRound(round, snapShots)
        }
    }

    fun printWinner(record: Record) {
        val winnerNames = record.getWinnerCarName()
        val joinedWinnerNames = winnerNames.joinToString(separator = ",")
        println("${joinedWinnerNames}$WINNER_MESSAGE")
    }

    private fun printRound(round: Int, snapShots: List<SnapShot>) {
        println("${round + 1} 번째 레이스")
        snapShots.forEach { snapShot ->
            println(snapShot.carName + " : " + "-".repeat(snapShot.carMovement.count { it }))
        }
    }
}
