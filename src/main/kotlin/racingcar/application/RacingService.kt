package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomEngine
import racingcar.presentation.OutputView

class RacingService {

    fun playNewRacingGameToEnd(listOfCarsName: List<String>, countOfRacingRound: Int) {
        val cars = Cars(createRandomCars(listOfCarsName))
        val racingGame = RacingGame(cars, countOfRacingRound)

        while (!racingGame.isFinished()) {
            racingGame.play()
            OutputView.printResultOfRacing(racingGame.getCars())
        }
        OutputView.printWinner(cars.getWinner())
    }

    private fun createRandomCars(listOfCarsName: List<String>): List<Car> {
        return listOfCarsName
            .map { Car(RandomEngine(), it) }
            .toList()
    }
}