package racinggame.view

class TestRacingGameOutputView : RacingGameOutputView {

    private val _captures = mutableListOf<RacingGameMessage>()
    val captures: List<RacingGameMessage> = _captures

    fun clear() {
        _captures.clear()
    }

    override fun displayMessage(racingGameMessage: RacingGameMessage) {
        _captures.add(racingGameMessage)
    }
}
