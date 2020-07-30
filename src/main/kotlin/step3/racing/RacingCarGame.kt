package step3.racing

import step3.racing.result.RacingResult
import step3.turn.Turn
import step3.turn.TurnManager

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
