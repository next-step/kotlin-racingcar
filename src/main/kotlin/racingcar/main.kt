package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.input.ReadInInput
import racingcar.view.output.PrintOutput

fun main() {
    val raceGame = RaceGame(InputView(ReadInInput()), OutputView(PrintOutput()))
    raceGame.run()
}
