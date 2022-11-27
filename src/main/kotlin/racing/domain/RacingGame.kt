package racing.domain

import racing.view.ResultView

class RacingGame {

    fun start(carNames: Array<String>, numberOfGames: Int): List<Car> {

        val cars = CarFactory.create(carNames)

        for (i in 1..numberOfGames) {
            cars.race { RandomGenerator.generate() }
            ResultView.printRacingGameResult(ResultView.toRaceResult(cars))
        }

        val winner = Winner(cars)
        return winner.win()
    }
}
