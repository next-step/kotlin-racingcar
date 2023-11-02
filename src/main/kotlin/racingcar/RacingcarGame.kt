package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.RacingcarGameManager
import racingcar.model.Car
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGame(
    private val racingcarGameManager: RacingcarGameManager,
    private val carMovementManager: CarMovementManager
) {
    fun play() {
        val input = RacingcarGameInputView.getInput()
        val cars = Car.create(input.carNames)

        RacingcarGameResultView.printGameStart()

        repeat(input.roundNumber) {
            carMovementManager.moveCarsWithCondition(cars)
            RacingcarGameResultView.printCarsDistance(cars)
        }
    }
}
