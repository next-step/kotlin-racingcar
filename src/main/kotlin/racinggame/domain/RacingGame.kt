package racinggame.domain

import racinggame.domain.employee.GameGuide

interface RacingGame {

    fun enter(gameGuide: GameGuide)
}
