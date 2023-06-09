package racinggame.view

class RacingGameController(
    private val inputView: RacingGameInputView,
    private val outputView: RacingGameOutputView,
) {

    fun start() {
        outputView.displayMessage(RacingGameMessage.PARTICIPANTS_INPUT)
        val participantsCount = receivePositiveIntegerFromViewOrNull()
        if (participantsCount == null) {
            outputView.displayMessage(RacingGameMessage.FINISH_WITH_NOT_POSITIVE_INTEGER)
        }
    }

    private fun receivePositiveIntegerFromViewOrNull(): Int? {
        return inputView.readLine()
            .toIntOrNull()
            ?.takeIf { it > 0 }
    }
}
