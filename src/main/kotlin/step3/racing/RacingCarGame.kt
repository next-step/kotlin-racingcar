package step3.racing

import step3.racing.car.Car
import step3.racing.const.GAME_RESULT
import step3.racing.result.RacingResult
import step3.racing.view.View
import step3.turn.TurnManager

class RacingCarGame(
    private val view: View,
    private val turnManager: TurnManager
) {
    fun startRacing(cars: List<Car>): RacingResult {
        view.print()
        view.print(GAME_RESULT)
        while (!turnManager.isFinishOrProceed()) {
            view.print()
        }
        return RacingResult(cars)
    }

    class SetupFailException(override val message: String) : Exception()
}
