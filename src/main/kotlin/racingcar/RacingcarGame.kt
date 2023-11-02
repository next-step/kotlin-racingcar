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

        startGame(cars, input.roundNumber)
    }

    private fun startGame(cars: List<Car>, round: Int) {
        RacingcarGameResultView.printGameStart()

        repeat(round) {
            carMovementManager.moveCarsWithCondition(cars)
            RacingcarGameResultView.printCarsDistance(cars)
        }

        val winners = racingcarGameManager.getWinners(cars)

        RacingcarGameResultView.printGameWinners(winners)
    }
}
