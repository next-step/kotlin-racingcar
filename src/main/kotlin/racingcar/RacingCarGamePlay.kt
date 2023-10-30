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
    val randomNumGenerator = RandomNumGenerator()
    var currentRacingCarGame = RacingCarGame.init(initRacingCars(racingCarNames))
    repeat(countOfRacing) {
        currentRacingCarGame = currentRacingCarGame.race(randomNumGenerator)
        ResultView.printResult(currentRacingCarGame)
    }
    val winners = currentRacingCarGame.calculateWinners()
    ResultView.printWinners(winners)
}

private fun initRacingCars(racingCarNames: List<String>): List<RacingCar> {
    val initRacingCars = mutableListOf<RacingCar>()
    for (racingCarName in racingCarNames) {
        initRacingCars.add(RacingCar(name = racingCarName))
    }
    return initRacingCars
}
