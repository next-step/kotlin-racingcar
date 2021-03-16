package racingcar

import racingcar.domain.RacingGame
import racingcar.ui.InputView
import racingcar.ui.OutputView
import racingcar.userInput.UserNameInfo

fun main(args: Array<String>) {
    val userNameInfo = UserNameInfo(InputView.getCarsUserName())
    val tryCount = InputView.getTryCounts()

    val racingGame = RacingGame(tryCount = tryCount, userNameInfo = userNameInfo)
    val raceHistory = racingGame.runRace()

    OutputView.printOutputLetter()
    OutputView.printRacingGame(raceHistory)
    OutputView.printRacingWinner(racingGame.getWinner())
}
