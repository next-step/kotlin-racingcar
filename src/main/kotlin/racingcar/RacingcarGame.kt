package racingcar

import racingcar.component.Cars
import racingcar.model.RacingcarGameInput
import racingcar.view.RacingcarGameResultView

class RacingcarGame {
    fun play(input: RacingcarGameInput) {
        val cars = Cars.create(input.carNames)

        startGame(cars, input.roundNumber)
    }

    private fun startGame(cars: Cars, round: Int) {
        RacingcarGameResultView.printGameStart()

        repeat(round) {
            cars.moveCars()
            RacingcarGameResultView.printCarsDistance(cars)
        }

        RacingcarGameResultView.printGameWinners(cars)
    }
}
