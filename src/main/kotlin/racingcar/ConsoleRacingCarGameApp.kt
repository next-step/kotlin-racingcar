package racingcar

import racingcar.service.RacingCarGameMachine
import racingcar.service.strategy.RandomNumberZeroToNineGenerate
import racingcar.ui.ConsoleInput
import racingcar.ui.ConsoleOutput

class RacingCarGameApp

fun main() {
    val racingCarGame = RacingCarGameMachine(RandomNumberZeroToNineGenerate())

    val carCount = ConsoleInput.getCarCount()
    val tryCount = ConsoleInput.getTryCount()

    val gameResults = racingCarGame.play(carCount, tryCount)
    ConsoleOutput.printGameResults(gameResults)
}
