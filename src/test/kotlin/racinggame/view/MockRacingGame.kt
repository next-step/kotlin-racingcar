package racinggame.view

import racinggame.domain.game.RacingGame
import racinggame.domain.game.RacingGameResult
import racinggame.domain.game.GameGuide
import racinggame.domain.record.RacingRecordBook

class MockRacingGame : RacingGame {

    var gameGuideCapture: GameGuide? = null
    var racingGameResultDelegator: (() -> RacingGameResult)? = null

    fun clear() {
        gameGuideCapture = null
    }

    override fun execute(gameGuide: GameGuide): RacingGameResult {
        gameGuideCapture = gameGuide
        return racingGameResultDelegator?.invoke() ?: RacingGameResult(RacingRecordBook(emptyList()))
    }
}
