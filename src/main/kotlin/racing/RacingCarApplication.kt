package racing

import racing.domain.RandomMoveStrategy
import racing.ui.RacingCarController
import view.console.ConsoleInput
import view.console.ConsoleOutput

val consoleOutput: ConsoleOutput = ConsoleOutput()
val consoleInput: ConsoleInput = ConsoleInput()

fun main() {
    consoleOutput.printCarCountInputMessage()
    val carCount = consoleInput.read()

    consoleOutput.printTryCountInputMessage()
    val tryCount = consoleInput.read()

    RacingCarController(RandomMoveStrategy()).run(carCount.toInt(), tryCount.toInt())
}
