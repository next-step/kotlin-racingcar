package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.RacingcarGameContext
import racingcar.model.Car
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGame(
    private val racingcarGameContext: RacingcarGameContext,
    private val carMovementManager: CarMovementManager
) {
    fun play() {
        val input = RacingcarGameInputView.getInput()
        val cars = Car.create(input.carNumber)

        RacingcarGameResultView.printGameStart()

        repeat(input.roundNumber) {
            carMovementManager.moveCarsWithCondition(cars)
            RacingcarGameResultView.printCarsDistance(cars)
        }
    }
}
