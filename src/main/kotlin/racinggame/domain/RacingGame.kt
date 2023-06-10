package racinggame.domain

import racinggame.domain.employee.GameGuide

interface RacingGame {

    fun execute(gameGuide: GameGuide): RacingGameResult
}
