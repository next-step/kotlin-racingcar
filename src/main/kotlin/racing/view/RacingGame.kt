package racing.view

import racing.service.GameMachine
import racing.view.AskingView.JOIN_CAR_COUNT_QUESTION
import racing.view.AskingView.TRY_GAME_COUNT_QUESTION

fun main() {
    val carNames = AskingView.askCarName(JOIN_CAR_COUNT_QUESTION)
    val tryGameCount = AskingView.askCounting(TRY_GAME_COUNT_QUESTION)

    val racing = GameMachine.play(carNames, tryGameCount)
    val winningCars = GameMachine.getWinningCarName(racing)
    PrintResultView.printResult(winningCars)
}
