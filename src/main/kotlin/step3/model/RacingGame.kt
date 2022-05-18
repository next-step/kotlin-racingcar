package step3.model

import step3.dto.GameSetting
import step3.dto.MoveResult
import step3.dto.TrackResult

class RacingGame(private val gameSetting: GameSetting) {

    private val racingTrack: RacingTrack = RacingTrack(gameSetting)

    fun race(): List<TrackResult> {
        return (1..gameSetting.moveCount)
            .toList()
            .map { racingTrack.move() }
            .map { TrackResult(it, winnerList(it)) }
    }

    private fun winnerList(moveResults: List<MoveResult>): List<Car> {
        return moveResults
            .groupBy({ it.position }, { it.car })
            .maxByOrNull { it.key }?.value ?: listOf()
    }
}
