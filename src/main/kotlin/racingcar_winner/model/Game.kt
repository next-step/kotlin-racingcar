package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val cars: Cars
) {
    private val numberOfCars: Int = cars.getNumberOfCars()
    private val randomNumberFactory = RandomNumberManager()
    private val outputView = Outputview()

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
        val progressOfCars = cars.getProgressOfCars()
        outputView.printOneRound(progressOfCars)
    }

    private fun printWinner() {
        val winners = cars.getWinners()
        outputView.printWinner(winners)
    }
}
