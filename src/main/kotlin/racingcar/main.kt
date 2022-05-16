package racingcar

import racingcar.race.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carCount: Int = inputView.getCarCount()
    val moveCount: Int = inputView.getMoveCount()
    val race: Race = Race(carCount, moveCount)
    val resultView = ResultView(race)
    resultView.show()
}
