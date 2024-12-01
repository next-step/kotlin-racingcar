package racingcar

import racingcar.application.RacingCarGame
import racingcar.ui.ConsoleCarNameReader
import racingcar.ui.ConsoleMessagePrinter
import racingcar.ui.ConsoleMoveAttemptCountReader

fun main() {
    val racingCarGame =
        RacingCarGame(
            messagePrinter = ConsoleMessagePrinter,
            moveAttemptCountReader = ConsoleMoveAttemptCountReader,
            carNameReader = ConsoleCarNameReader,
        )
    racingCarGame.start()
}
