package racingcar

import racingcar.strategy.RandomStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.util.function.Consumer
import java.util.function.Supplier

fun main() {
    val inputView = InputView.builder()
        .player(Consumer(::println), Supplier(::readLine))
        .repetition(Consumer(::println), Supplier(::readLine))
        .build()

    val resultView = ResultView()

    val racingGameManager = RacingGameManager.builder(inputView, resultView)
        .strategy(RandomStrategy())
        .build()

    racingGameManager.racing(Consumer { racingGameManager.showRacingResult() })
}
