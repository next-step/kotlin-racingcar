package racingcar.application

import racingcar.domain.RaceRecord

data class GameResult(
    val winners: List<String>,
    val raceResults: List<RaceResult>,
)

data class RaceResult(
    val phaseOfRace: Int,
    val raceRecord: RaceRecord
)
