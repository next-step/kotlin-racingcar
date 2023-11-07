package racingcar

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarGame
import racingcar.ui.InputView
import racingcar.ui.ResultView
import racingcar.util.RandomNumGenerator

fun main() {
    val racingCarNames = InputView.inputNames()
    val countOfRacing = InputView.inputCount()

    ResultView.printInitMessage()
    val racingCarGame = RacingCarGame.init(initRacingCars(racingCarNames))
    val randomNumGenerator = RandomNumGenerator()
    repeat(countOfRacing) {
        racingCarGame.race(randomNumGenerator)
        ResultView.printResult(racingCarGame)
    }
    val winners = racingCarGame.findWinners()
    ResultView.printWinners(winners)
}

private fun initRacingCars(racingCarNames: List<String>): List<RacingCar> {
    return racingCarNames.map { RacingCar(name = it) }
}
