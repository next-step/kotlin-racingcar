package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.getCarNams()
    val tryNo = InputView.getTryNo()

    val racingGame = RacingGame(carNames, tryNo)
    while(!racingGame.isEnd()) {
        val cars = racingGame.race()
        ResultView.printRaceStatus(cars)
    }

    val winners = racingGame.findWinners()
    ResultView.printWinners(winners)
}
