package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner

internal class MultipleWinnersAllowedImpl : RankingPolicy.MultipleWinnersAllowed {
    override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.MultipleWinner {
        val maxPositionX = racingCarRoad.cars.maxBy { it.position.xPos }.position.xPos
        val winners = racingCarRoad.cars.filter { it.position.xPos == maxPositionX }
        return RacingCarWinner.MultipleWinner(winners)
    }
}
