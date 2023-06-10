package racinggame.view

class TestRacingGameOutputView : RacingGameOutputView {

    private val _fixedMessagesCapture = mutableListOf<RacingGameFixedMessage>()
    val fixedMessagesCapture: List<RacingGameFixedMessage> = _fixedMessagesCapture

    fun clear() {
        _fixedMessagesCapture.clear()
    }

    override fun display(racingGameFixedMessage: RacingGameFixedMessage) {
        _fixedMessagesCapture.add(racingGameFixedMessage)
    }

    override fun display(racingCarMoveDistance: RacingCarMoveDistance) {
    }
}
