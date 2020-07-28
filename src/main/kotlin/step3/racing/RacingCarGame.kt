package step3.racing

import step3.racing.const.GAME_RESULT
import step3.racing.view.View
import step3.turn.TurnManager

class RacingCarGame(
    private val view: View,
    private val turnManager: TurnManager
) {
    fun startRacing() {
        view.print()
        view.print(GAME_RESULT)
        while (!turnManager.isFinishOrProceed()) {
            view.print()
        }
    }

    class SetupFailException(override val message: String) : Exception()
}
