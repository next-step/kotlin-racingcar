package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner

class MultipleWinnersAllowedImpl : RankingPolicy.MultipleWinnersAllowed {
    override fun RacingCarRoad.determineWinner(): RacingCarWinner.MultipleWinner {
        val maxPositionX = cars.maxBy { it.position.xPos }.position.xPos
        val winners = cars.filter { it.position.xPos == maxPositionX }
        return RacingCarWinner.MultipleWinner(winners)
    }
}
