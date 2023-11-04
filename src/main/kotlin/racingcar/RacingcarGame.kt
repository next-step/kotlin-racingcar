package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.Cars
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGame(
    private val carMovementManager: CarMovementManager
) {
    fun play() {
        val input = RacingcarGameInputView.getInput()
        val cars = Cars.create(input.carNames)

        startGame(cars, input.roundNumber)
    }

    private fun startGame(cars: Cars, round: Int) {
        RacingcarGameResultView.printGameStart()

        repeat(round) {
            carMovementManager.moveCarsWithCondition(cars)
            RacingcarGameResultView.printCarsDistance(cars)
        }

        val winners = cars.getWinners()

        RacingcarGameResultView.printGameWinners(winners)
    }
}
