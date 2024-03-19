package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomEngine
import racingcar.presentation.OutputView

class RacingService {

    fun playNewRacingGameToEnd(countOfCars: Int, countOfRacingRound: Int) {
        val cars = Cars(createRandomCars(countOfCars))
        val racingGame = RacingGame(cars, countOfRacingRound)

        while (!racingGame.isFinished()) {
            racingGame.play()
            OutputView.printResultOfRacing(racingGame.getCars())
        }
    }

    private fun createRandomCars(countOfCars: Int): List<Car> {
        return (0 until countOfCars)
            .map { Car(RandomEngine(), it.toString()) }
            .toList()
    }
}