package racingcar.application

import racingcar.domain.GameRecord
import racingcar.domain.RaceRecord

data class GameResult(
    val raceResults: List<RaceResult>
) {
    companion object {
        fun of(gameRecord: GameRecord): GameResult {
            val raceResults = gameRecord.raceRecords
                .mapIndexed { i, raceRecord ->
                    RaceResult(i + 1, raceRecord)
                }
            return GameResult(raceResults)
        }
    }
}

data class RaceResult(
    val phaseOfRace: Int,
    val raceRecord: RaceRecord
)
