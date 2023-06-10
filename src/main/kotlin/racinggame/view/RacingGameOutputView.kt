package racinggame.view

interface RacingGameOutputView {

    fun display(racingGameFixedMessage: RacingGameFixedMessage)
    fun display(racingCarMoveDistance: RacingCarMoveDistance)
}
