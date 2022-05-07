package step3.view

import step3.model.RacingGame

class InputLayout(
    private val carInputView: InputView,
    private val attemptInputView: InputView
) {
    fun receiveUserInput() = RacingGame(
        carInputView.receive(),
        attemptInputView.receive()
    )
}