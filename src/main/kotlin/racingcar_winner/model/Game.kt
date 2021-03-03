package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val cars: Cars
) {
    private val gameManager = GameManager(cars)
    private val numberOfCars: Int = gameManager.getNumberOfCars()
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
        val progressOfCars = gameManager.getProgressOfCars()
        outputView.printOneRound(progressOfCars)
    }

    private fun printWinner() {
        val highScore = gameManager.getHighScore()
        val winners = gameManager.getWinners(highScore)
        outputView.printWinner(winners)
    }
}
