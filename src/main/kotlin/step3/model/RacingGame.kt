package step3.model

import step3.dto.GameSetting
import step3.dto.TrackResult

class RacingGame(private val gameSetting: GameSetting) {

    private val racingTrack: RacingTrack = RacingTrack(gameSetting)

    fun racing(): List<TrackResult> {
        return (1..gameSetting.moveCount)
            .toList()
            .map { racingTrack.move() }
            .map { TrackResult(it) }
    }
}
