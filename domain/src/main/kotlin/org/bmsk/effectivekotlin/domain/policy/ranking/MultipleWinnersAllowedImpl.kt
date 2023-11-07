package org.bmsk.effectivekotlin.domain.policy.ranking

import org.bmsk.effectivekotlin.domain.model.RacingCarRoad
import org.bmsk.effectivekotlin.domain.model.RacingCarWinner

class MultipleWinnersAllowedImpl : RankingPolicy.MultipleWinnersAllowed {
    override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.MultipleWinner {
        val winners = racingCarRoad.findCarsWentFurthest()
        return RacingCarWinner.MultipleWinner(winners)
    }
}
