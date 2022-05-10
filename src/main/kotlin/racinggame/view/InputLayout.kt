package racinggame.view

import racinggame.model.RacingGameInput

class InputLayout(
    private val carInputView: InputView,
    private val attemptInputView: InputView
) {
    fun receiveUserInput() = RacingGameInput(
        carInputView.receive(),
        attemptInputView.receive()
    )
}
