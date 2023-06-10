package racinggame.view

class RealRacingGameOutputView : RacingGameOutputView {

    override fun display(racingGameFixedMessage: RacingGameFixedMessage) {
        println(racingGameFixedMessage.koreaGuideMessage)
    }

    override fun display(racingCarMoveDistance: RacingCarMoveDistance) {
        repeat(racingCarMoveDistance.distance) {
            print("-")
        }
        println()
    }
}
