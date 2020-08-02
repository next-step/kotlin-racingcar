import manager.CarManager
import model.Dice
import view.InputView
import view.ResultView

fun main(args: Array<String>) {
    val carManager = CarManager(Dice())
    val inputView = InputView()
    val inputFunction = { readLine()!! }

    val driverList = inputView.inputCarsWithName(inputFunction)
    carManager.addCarByDrivers(driverList)

    val tryMoveCount = inputView.inputTryMoveCount(inputFunction)
    carManager.tryCount = tryMoveCount
    carManager.tryMoving()

    val resultView = ResultView(carManager)
    resultView.status()
}
