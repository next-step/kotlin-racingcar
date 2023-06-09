package racinggame.view

import racinggame.domain.RacingGame
import racinggame.domain.employee.GameGuide

class TestRacingGame: RacingGame {

    var gameGuideCapture: GameGuide? = null

    fun clear() {
        gameGuideCapture = null
    }

    override fun enter(gameGuide: GameGuide) {
        gameGuideCapture = gameGuide
    }
}
