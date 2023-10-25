package racinggame

import java.util.Random

fun main() {
    val carCount = InputView.input("자동차 대수는 몇 대인가요?")
    val tryCount = InputView.input("시도할 횟수는 몇 회인가요?")

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

    OutputView.output(result)
}