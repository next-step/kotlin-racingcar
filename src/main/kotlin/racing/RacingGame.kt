package racing

import racing.view.InputView
import racing.view.OutputView
import java.util.*

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val listOfNames = inputView.getNames()
    val numberOfGames = inputView.getNumberOfGames()

    val random = Random()
    val racingCars = Cars.init(listOfNames, MoveStrategy { random.nextInt(10) >= 4 })

    outputView.printResultString()
    repeat(numberOfGames) {
        racingCars.move()
        outputView.printResult(racingCars.getDistancesWithNames())
    }

    outputView.printWinners(racingCars.getWinners())
}
