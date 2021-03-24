package car

import car.domain.CarNames
import car.domain.Cars
import car.domain.Game
import car.view.InputView
import car.view.ResultView

fun main() {
    val inputView = InputView()

    val names = inputView.inputNames()
    val tryCount = inputView.inputTryCount()
    val prettyString = inputView.inputPrettyString()

    val game: Game = Game(Cars(CarNames(names.splitNameBySplitter())))

    game.move(tryCount.count)

    val resultView = ResultView()

    resultView.print(game.allCarMoveHistories, prettyString.printer)
    resultView.printWinners(game.winners)
}
