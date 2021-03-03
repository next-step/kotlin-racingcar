package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val cars: Cars
) {
    private val numberOfCars: Int = cars.getNumberOfCars()
    private val randomNumberFactory = RandomNumberManager()
    private val outputView = Outputview()
    private val referee = Referee()

    fun playGame() {
        repeat(numberOfRound) {
            playOneRound()
            printOneRound()
        }

        printWinner()
    }

    private fun playOneRound() {
        cars.moveAll(randomNumberFactory)
    }

    private fun printOneRound() {
        val progressOfCars: Map<String, Int> = cars.getProgressOfCars()
        outputView.printOneRound(progressOfCars)
    }

    private fun printWinner() {
        val winners = referee.getWinners(cars)
        outputView.printWinner(winners)
    }
}
