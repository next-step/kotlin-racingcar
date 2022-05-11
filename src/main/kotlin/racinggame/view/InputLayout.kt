package racinggame.view

import racinggame.domain.model.RacingGameInput

class InputLayout(
    private val carInputView: InputView,
    private val attemptInputView: InputView
) {
    fun receiveUserInput() = RacingGameInput(
        carInputView.receive(),
        attemptInputView.receive()
    )
}
