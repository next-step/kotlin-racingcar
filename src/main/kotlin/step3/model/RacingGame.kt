package step3.model

import step3.dto.GameResult
import step3.dto.GameSetting
import step3.dto.MoveResult

class RacingGame(private val gameSetting: GameSetting) {

    private val carList: List<Car> = List(gameSetting.inputCarCount) { i -> Car(i) }

    fun racing(): List<GameResult> {
        return (1..gameSetting.inputMoveCount)
            .toList()
            .map { move() }
            .map { GameResult(it) }
    }

    private fun move(): List<MoveResult> {
        return carList
            .onEach { it.move() }
            .map { MoveResult(it.id, it.position) }
    }
}
