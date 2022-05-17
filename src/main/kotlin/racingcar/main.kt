package racingcar

import racingcar.race.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val race = Race(inputView.getCarCount(), inputView.getMoveCount())
    val resultView = ResultView(race)
    resultView.show()
}
