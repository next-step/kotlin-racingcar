package racing.domain

import racing.ui.InputView
import racing.ui.ResultView

class RacingGame {

    fun start() {

        val carCount = InputView.requireCarsCount()
        val cars = CarFactory.create(carCount)
        var numberOfGames = InputView.requireNumberOfGames()

        while (numberOfGames-- > 0) {
            cars.race {
                RandomGenerator.generate()
            }
        }

        ResultView.printGameResult(ResultStatistics(cars).toResult())
    }
}
