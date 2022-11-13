import racingcar.domain.GameInputValue
import racingcar.domain.InputNumber
import racingcar.domain.RacingGameController
import racingcar.view.InputView

fun main() {
    /*
    ** code for calculator
    val input = CalculationExpression(InputView().getUserInput())
    println(Calculator().calculate(input))
     */

    // code for racing car
    val inputNumberOfCar = InputNumber(InputView().getNumberOfCar()).number
    val inputNumberOfTrying = InputNumber(InputView().getNumberOfTrying()).number
    val gameInputValue = GameInputValue(inputNumberOfCar, inputNumberOfTrying)
    RacingGameController().start(gameInputValue)
}
