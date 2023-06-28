package racingcar

import racingcar.service.RacingCarGameMachine
import racingcar.service.strategy.RandomNumberZeroToNineGenerate
import racingcar.ui.ConsoleInput
import racingcar.ui.ConsoleOutput

class RacingCarGameApp

fun main() {
    val racingCarGame = RacingCarGameMachine(RandomNumberZeroToNineGenerate())

    val carNames = ConsoleInput.getCarNames()
    val tryCount = ConsoleInput.getTryCount()

    val gameResults = racingCarGame.play(carNames, tryCount)
    ConsoleOutput.printGameResults(gameResults)
    racingCarGame.getWinners(gameResults).let { winners ->
        ConsoleOutput.printWinners(winners)
    }
}
