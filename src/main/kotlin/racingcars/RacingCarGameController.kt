package racingcars

import racingcars.domain.Car
import racingcars.domain.Winners
import racingcars.strategy.SingleDigitRandomNumberGenerator
import racingcars.view.InputView
import racingcars.view.ResultView

class RacingCarGameController {
    private val inputView = InputView { readln() }
    private val resultView = ResultView()

    fun start() {
        val racingCars = initializeCars()
        playGame(racingCars)
        printWinners(racingCars)
    }

    private fun initializeCars(): List<Car> {
        val racingCarNames = inputView.getCarNames()
        val numberOfCar = inputView.getNumberOfCars()
        return Car.fromInput(numberOfCar, racingCarNames)
    }

    private fun playGame(racingCars: List<Car>) {
        val attemptCount = inputView.getAttemptCount()
        repeat(attemptCount) {
            playRound(racingCars)
            resultView.printRaceResults(racingCars)
        }
    }

    private fun printWinners(racingCars: List<Car>) {
        val winners = Winners.find(racingCars)
        resultView.printWinners(winners)
    }

    private fun playRound(racingCars: List<Car>) {
        val randomNumberGenerator = SingleDigitRandomNumberGenerator()
        racingCars.forEach {
            it.moveForward(randomNumberGenerator.generate())
        }
    }
}

