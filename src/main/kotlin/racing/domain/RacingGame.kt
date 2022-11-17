package racing.domain

import racing.ui.InputView
import racing.ui.ResultView

class RacingGame {

    fun start() {

        val carCount = InputView.requireCarsCount()
        val cars = CarFactory.create(carCount)
        var numberOfGames = InputView.requireNumberOfGames()

        while (numberOfGames-- > 0) {
            race(cars)
        }

        ResultView.printGameResult(ResultStatistics(cars).toResult())
    }

    private fun race(cars: Cars) {
        for (car in cars.list()) {
            car.move(RandomGenerator.generate())
        }
    }
}
