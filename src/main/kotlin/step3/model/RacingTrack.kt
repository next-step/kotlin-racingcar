package step3.model

import step3.dto.GameSetting
import step3.dto.MoveResult

class RacingTrack(gameSetting: GameSetting) {

    private val trackLines: List<TrackLine> = gameSetting.carNames
        .map { Car(it) }
        .map { TrackLine(it) }

    fun move(): List<MoveResult> {
        return trackLines
            .onEach { it.move() }
            .map { MoveResult(it.car, it.position) }
    }
}
