package racinggame.view

import racinggame.domain.game.RacingGameResult

class MockRacingGameResultView : RacingGameResultView {

    var racingGameResultCapture: RacingGameResult? = null
        private set

    override fun display(racingGameResult: RacingGameResult) {
        racingGameResultCapture = racingGameResult
    }
}
