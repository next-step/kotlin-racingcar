import manager.CarManager
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val carManager = CarManager()
    val inputView = InputView(carManager)
    inputView.inputCarCount(readLine()!!)
    inputView.inputTryMoveCount(readLine()!!)
    val resultView = ResultView(carManager)
    resultView.status()
}
