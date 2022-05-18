package racingCar

import racingCar.lib.UserInputData
import racingCar.ui.InputView

fun main() {
    val userInput: UserInputData = UserInputData(InputView().getNumOfCarsInput(), InputView().getNumOfMovesInput())
    RacingGame(userInput).play()
}