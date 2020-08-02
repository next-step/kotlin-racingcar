package racingcar.turn

import racingcar.racing.result.RacingResult

interface TurnManager {
    val totalSteps: Int
    fun isFinish(): Boolean
    fun nextTurn(): List<RacingResult>
    fun startRaceUntilFinish(): List<RacingResult>
}
