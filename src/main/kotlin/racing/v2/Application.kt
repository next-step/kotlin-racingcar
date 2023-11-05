package racing.v2

import racing.v2.console.InputView

fun main() {
    InputView.printCarNamesPrompt()
    val carsStr = InputView.getUserInput()

    InputView.printTryCountPrompt()
    val tryCountStr = InputView.getUserInput()

    val carGame = InputView.createCarGame(carsStr, tryCountStr)
    carGame.start()
}
