package racingCarWinner

import racingCarWinner.domain.Car
import racingCarWinner.domain.MoveStrategy
import racingCarWinner.domain.RandomMoveStrategy
import racingCarWinner.view.InputView
import racingCarWinner.view.ResultView

class RacingGame private constructor(
    private val racingCars: List<Car>,
    private val numOfAttempts: Int
) {

    fun start(): List<Car> {
        ResultView.printResultText()
        repeat(numOfAttempts) {
            racingCars.forEach { it.move() }
            ResultView.printResultState(racingCars)
        }
        return racingCars
    }

    fun selectWinner(): List<String> {
        val maxLocation = racingCars.maxOf { it.location }
        val winnerCars = racingCars.filter { it.location == maxLocation }
        return winnerCars.map { it.name }.also { name -> ResultView.printWinners(name) }
    }

    companion object {
        fun of(carNames: List<String>, strategy: MoveStrategy, numOfAttempts: Int): RacingGame {
            return RacingGame(
                racingCars = carNames.map {
                    Car.of(
                        strategy = strategy,
                        name = it
                    )
                },
                numOfAttempts = numOfAttempts
            )
        }
    }
}

fun main() {
    val inputs = InputView.gatherUserInput()
    val racingGame = RacingGame.of(
        carNames = inputs.carNames,
        strategy = RandomMoveStrategy,
        numOfAttempts = inputs.numOfAttempts
    )
    racingGame.start()
    racingGame.selectWinner()
}