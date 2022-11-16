package racing.domain

import racing.ui.InputView
import racing.ui.ResultView

class RacingGame {

    fun start() {

        ResultView.requireCarsCount()
        val cars = Cars(InputView.inputNumber())

        ResultView.requireNumberOfGames()
        var count = InputView.inputNumber()

        while (count-- > 0) {
            race(cars)
        }

        ResultView.printGameResult(ResultStatistics(cars).toResult())
    }

    private fun race(cars: Cars) {
        for (car in cars) {
            car.move(RandomGenerator.generate())
        }
    }
}
