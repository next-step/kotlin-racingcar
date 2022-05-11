package racinggame.view

import racinggame.domain.model.RacingGameInput

class InputLayout(
    private val carInputView: InputView<List<String>>,
    private val attemptInputView: InputView<Int>
) {
    fun receiveUserInput() = RacingGameInput(
        carInputView.receive(),
        attemptInputView.receive()
    )
}
