package racingcar_winner.model

import racingcar_winner.ui.Outputview

class Game(
    private val numberOfRound: Int,
    private val carNames: List<String>
) {
    private val cars: Cars = Cars.makeCars(carNames)
    private val randomNumberFactory = RandomNumberManager()
    private val outputView = Outputview()

    fun playGame() {
        repeat(numberOfRound) {
            cars.moveAll(randomNumberFactory)
            outputView.printProgressOfCars(cars)
            println()
        }
        outputView.printWinner(cars)
    }
}
