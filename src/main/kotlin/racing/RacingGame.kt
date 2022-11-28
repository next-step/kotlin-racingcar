package racing

import racing.domain.Cars
import racing.view.InputView
import racing.view.OutputView
import java.util.Random

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val names = inputView.getNames()
    val numberOfGames = inputView.getNumberOfGames()

    val random = Random()
    val racingCars = Cars.init(names, MoveStrategy { random.nextInt(10) >= 4 })

    outputView.printResultString()
    repeat(numberOfGames) {
        racingCars.move()
        outputView.printResult(racingCars.getDistancesWithNames())
    }

    outputView.printWinners(racingCars.getWinners())
}
