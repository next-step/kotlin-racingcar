import manager.CarManager
import model.Dice
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val carManager = CarManager(Dice())
    val inputView = InputView()
    val inputFunction = { readLine()!! }

    try {
        val driverList = inputView.inputCarsWithName(inputFunction)
        carManager.addCarByDrivers(driverList)
    } catch (ex: IllegalArgumentException) {
        inputView.printErrorMessage()
        return
    }

    try {
        val tryMoveCount = inputView.inputTryMoveCount(inputFunction)
        carManager.tryCount = tryMoveCount
        carManager.tryMoving()
    } catch (ex: IllegalArgumentException) {
        inputView.printErrorMessage()
        return
    }

    val resultView = ResultView(carManager)
    resultView.status()
}
