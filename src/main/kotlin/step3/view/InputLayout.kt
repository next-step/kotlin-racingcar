package step3.view

import step3.model.RacingGameInput

class InputLayout(
    private val carInputView: InputView,
    private val attemptInputView: InputView
) {
    fun receiveUserInput() = RacingGameInput(
        carInputView.receive(),
        attemptInputView.receive()
    )
}
