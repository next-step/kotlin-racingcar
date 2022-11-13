package racing

import racing.view.InputView
import racing.view.OutputView
import java.util.*


fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val numberOfCars = inputView.getNumberOfCars()
    val numberOfGames = inputView.getNumberOfGames()

    val random = Random()
    val racingCars = Cars.init(numberOfCars, MoveStrategy { random.nextInt(10) >= 4 })

    outputView.printResultString()
    repeat(numberOfGames) {
        racingCars.move()
        outputView.printResult(racingCars.getDistances())
    }
}
