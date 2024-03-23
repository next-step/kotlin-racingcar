package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomEngine
import racingcar.presentation.OutputView

/**
 * MVC 패턴상에선 RacingService가 Controller 역할. (도메인들의 비즈니스 처리를 위임하고 순서를 관장하는 역할)
 */
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