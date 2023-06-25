package racingcar

import racingcar.service.RacingCarGameMachine
import racingcar.service.strategy.NumberZeroGenerate
import racingcar.service.strategy.RandomNumberZeroToNineGenerate
import racingcar.ui.ConsoleInput
import racingcar.ui.ConsoleOutput

class RacingCarGameApp

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()
    val racingCarGame = RacingCarGameMachine(RandomNumberZeroToNineGenerate())

    val carCount = input.getCarCount()
    val tryCount = input.getTryCount()

    val gameResults = racingCarGame.play(carCount, tryCount)
    output.printGameResults(gameResults)
}
