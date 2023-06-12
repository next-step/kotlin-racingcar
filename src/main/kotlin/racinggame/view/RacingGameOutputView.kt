package racinggame.view

import racinggame.domain.game.RacingGameResult

interface RacingGameOutputView {

    fun display(racingGameFixedMessage: RacingGameFixedMessage)
    fun display(racingGameResult: RacingGameResult)
}
