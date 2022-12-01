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

    fun printSnapShot(snapShot: SnapShot) {
        println("${snapShot.round + 1} 번째 레이스")
        snapShot.movedCars.forEach { car ->
            println(car.name + " : " + "-".repeat(car.movements.count { it }))
        }
    }
}
