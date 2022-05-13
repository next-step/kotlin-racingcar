package racingcar.domain

import racingcar.application.GameResult
import racingcar.application.RaceResult

object GameReferee {

    fun rank(gameRecord: GameRecord): GameResult {
        val lastRaceRecord = gameRecord.run {
            require(raceRecords.isNotEmpty()) { "경주 기록이 존재하지 않습니다." }
            raceRecords.last()
        }

        val raceResults = gameRecord.raceRecords
            .mapIndexed { i, raceRecord ->
                RaceResult(i + 1, raceRecord)
            }

        val winningDistance = findWinningDistance(lastRaceRecord)
        val winners = findWinner(winningDistance, lastRaceRecord)

        return GameResult(winners, raceResults)
    }

    private fun findWinningDistance(lastRaceRecord: RaceRecord): Int {
        return lastRaceRecord.cars.maxOf { it.currentPosition }
    }

    private fun findWinner(winningDistance: Int, lastRaceRecord: RaceRecord): List<String> {
        return lastRaceRecord.cars
            .filter { it.currentPosition == winningDistance }
            .map { it.name }
    }
}
