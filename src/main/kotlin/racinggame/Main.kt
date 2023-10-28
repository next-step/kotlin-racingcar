package racinggame

import java.util.Random

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(
        (1..carCount).map { Car() },
        tryCount
    ) { Random().nextInt() }

    val result = game.play().translate()

    OutputView.printRacingResult(result)
}
