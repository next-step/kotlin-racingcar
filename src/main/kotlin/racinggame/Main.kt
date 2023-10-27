package racinggame

import java.util.Random

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(
        (1..carCount).map { Car() },
    ) { Random().nextInt() }

    val result = (1..tryCount).map { _ ->
        game.play()
        game.currentPositions().map {
            (0..it).map {
                "-"
            }.reduce { s1, s2 ->
                s1 + s2
            }
        }
    }

    OutputView.printRacingResult(result)
}
