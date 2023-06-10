package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.RacingGameResult
import racinggame.domain.employee.GameGuide
import racinggame.domain.record.RacingRecordBook

class TestRacingGame : RacingGame {

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
