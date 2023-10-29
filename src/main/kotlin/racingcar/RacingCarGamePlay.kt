package racingcar

import racingcar.domain.Racer
import racingcar.domain.RacingCarGame
import racingcar.ui.InputView
import racingcar.ui.ResultView
import racingcar.util.RandomNumGenerator

fun main() {
    val countOfRacer = InputView.inputCountOfRacer()
    val countOfRacing = InputView.inputCountOfRacing()

    ResultView.printInitMessage()
    val randomNumGenerator = RandomNumGenerator()
    var currentRacingCarGame = RacingCarGame.init(initRacers(countOfRacer))
    repeat(countOfRacing) {
        currentRacingCarGame = currentRacingCarGame.race(randomNumGenerator)
        ResultView.printResult(currentRacingCarGame)
    }
}

private fun initRacers(countOfRacer: Int): MutableList<Racer> {
    val initRacers = mutableListOf<Racer>()
    repeat(countOfRacer) {
        initRacers.add(Racer())
    }
    return initRacers
}
