package racing

import racing.domain.movement.RandomMoveStrategy
import racing.ui.RacingCarController
import view.console.ConsoleInput
import view.console.ConsoleOutput

val consoleOutput: ConsoleOutput = ConsoleOutput()
val consoleInput: ConsoleInput = ConsoleInput()

fun main() {
    consoleOutput.printCarNameInputMessage()
    val carNames = consoleInput.read()

    consoleOutput.printTryCountInputMessage()
    val tryCount = consoleInput.read()

    val racingCarDto = RacingCarController(RandomMoveStrategy()).run(carNames, tryCount.toInt())

    consoleOutput.printRacingGameResultMessage()
    consoleOutput.printRacingGameRecord(racingCarDto)
}
