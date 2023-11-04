package racingcar

import racingcar.component.Cars
import racingcar.model.RacingcarGameInput
import racingcar.view.RacingcarGameResultView

class RacingcarGame(
    private val resultView: RacingcarGameResultView
) {
    fun play(input: RacingcarGameInput) {
        val cars = Cars.create(input.carNames)

        startGame(cars, input.rounds)
    }

    private fun startGame(cars: Cars, round: Int) {
        resultView.printGameStart()

        repeat(round) {
            cars.moveCars()
            resultView.printCarsDistance(cars)
        }

        resultView.printGameWinners(cars)
    }
}
