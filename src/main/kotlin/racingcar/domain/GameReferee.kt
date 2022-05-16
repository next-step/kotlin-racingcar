package racingcar.domain

import racingcar.application.GameResult
import racingcar.application.RaceResult

object GameReferee {

    fun rank(gameRecord: GameRecord): GameResult {
        require(gameRecord.isNotEmpty()) { "경주 기록은 비어있을 수 없습니다." }
        val lastRaceRecord = gameRecord.last()

        val raceResults = gameRecord.raceRecords
            .mapIndexed { i, raceRecord ->
                RaceResult(i + 1, raceRecord)
            }

        val winners = lastRaceRecord.findLeader()
            .map { it.name }

        return GameResult(winners, raceResults)
    }
}
