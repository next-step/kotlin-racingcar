package racingcar.racing

import racingcar.racing.result.RacingResult
import racingcar.turn.Turn
import racingcar.turn.TurnManager

class RacingCarGame(
    private val turnManager: TurnManager
) {
    fun startRacing(): RacingResult {
        var last = turnManager.isFinishOrProceed()
        val results = arrayListOf<Turn>()
        while (last != null) {
            results.add(last)
            last = turnManager.isFinishOrProceed()
        }
        return RacingResult(results)
    }

    class SetupFailException(override val message: String) : Exception()
}
