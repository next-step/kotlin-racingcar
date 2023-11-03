package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner

internal class MultipleWinnersAllowedImpl : RankingPolicy.MultipleWinnersAllowed {
    override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.MultipleWinner {
        val winners = racingCarRoad.findCarsWentFurthest()
        return RacingCarWinner.MultipleWinner(winners)
    }
}
