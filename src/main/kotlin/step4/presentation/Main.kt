package step4.presentation

import step4.domain.ConsoleInputSupplier
import step4.domain.RacingGame

fun main() {
    val racingGame = RacingGame(InputView(ConsoleInputSupplier()), ResultView)
    racingGame.run()
}
