package racinggame.view

import racinggame.domain.game.RacingGameResult

class MockRacingGameOutputView : RacingGameOutputView {

    private val _fixedMessagesCapture = mutableListOf<RacingGameFixedMessage>()
    val fixedMessagesCapture: List<RacingGameFixedMessage> = _fixedMessagesCapture

    var racingGameResultCapture: RacingGameResult? = null
        private set

    fun clear() {
        _fixedMessagesCapture.clear()
    }

    override fun display(racingGameFixedMessage: RacingGameFixedMessage) {
        _fixedMessagesCapture.add(racingGameFixedMessage)
    }

    override fun display(racingGameResult: RacingGameResult) {
        racingGameResultCapture = racingGameResult
    }
}
