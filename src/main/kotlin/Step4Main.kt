import manager.CarManager
import model.Dice
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val carManager = CarManager(Dice())
    val inputView = InputView(carManager)
    inputView.inputCarsWithName { readLine()!! }
    inputView.inputTryMoveCount { readLine()!! }
    val resultView = ResultView(carManager)
    resultView.status()
}
