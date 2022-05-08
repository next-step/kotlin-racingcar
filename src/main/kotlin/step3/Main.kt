package step3

import step3.view.InputLayout
import step3.view.InputView
import step3.view.RacingGameLayout
import step3.view.ResultView

private const val INPUT_MESSAGE_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?"
private const val INPUT_MESSAGE_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?"

fun main() {
    val racingGameLayout = RacingGameLayout(
        inputLayout = InputLayout(
            carInputView = InputView(INPUT_MESSAGE_NUMBER_OF_CARS),
            attemptInputView = InputView(INPUT_MESSAGE_NUMBER_OF_ATTEMPTS)
        ),
        resultView = ResultView()
    )
    racingGameLayout.execute()
}
