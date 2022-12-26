package race.view

import race.Record
import race.SnapShot
import race.view.Message.WINNER_MESSAGE

object Output {

    fun printResult(record: Record) {
        val carNames = record.carNames
        repeat(record.lastRound + 1) { round ->
            val snapShotsUpToRound = record.raceSnapshots.filter { it.round <= round }
            printRound(round, snapShotsUpToRound, carNames)
        }
    }

    fun printWinner(record: Record) {
        val winnerCarNames = getWinnerCarName(record)
        val joinedWinnerNames = winnerCarNames.joinToString(separator = ",")
        println("${joinedWinnerNames}$WINNER_MESSAGE")
    }

    private fun printRound(round: Int, snapShots: List<SnapShot>, carNames: List<String>) {
        println("${round + 1} 번째 레이스")
        carNames.forEach { carName ->
            val movements = calcCarMovements(snapShots, carName)
            println(carName + " : " + "-".repeat(movements))
        }
    }

    fun getWinnerCarName(record: Record): List<String> {
        val maxMovementsCount = record.carNames
            .map { calcCarMovements(record.raceSnapshots, it) }
            .maxOf { it }

        return record.carNames.filter { maxMovementsCount == calcCarMovements(record.raceSnapshots, it) }
    }

    private fun calcCarMovements(snapShots: List<SnapShot>, carName: String): Int {
        return snapShots.filter { it.carName == carName }.map { it.isMovement }.count { it }
    }
}
