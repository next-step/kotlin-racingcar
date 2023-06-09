package racinggame.view

class RealRacingGameOutputView : RacingGameOutputView {

    override fun displayMessage(racingGameMessage: RacingGameMessage) {
        println(racingGameMessage.koreaGuideMessage)
    }
}
