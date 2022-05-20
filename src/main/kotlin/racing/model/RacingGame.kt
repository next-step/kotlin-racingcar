package racing.model

import racing.dto.GameSetting
import racing.dto.MoveResult
import racing.dto.TrackResult

class RacingGame(private val gameSetting: GameSetting) {

    private val racingTrack: RacingTrack = RacingTrack(gameSetting)
    private val record = RacingRecord()

    fun race() {
        (1..gameSetting.moveCount)
            .toList()
            .map { racingTrack.move() }
            .map { TrackResult(it, winnerList(it)) }
            .forEach(record::add)
    }

    fun getResults(): List<TrackResult> {
        return record.getResults()
    }

    private fun winnerList(moveResults: List<MoveResult>): List<Car> {
        return moveResults
            .groupBy({ it.position }, { it.car })
            .maxByOrNull { it.key }?.value ?: listOf()
    }
}
