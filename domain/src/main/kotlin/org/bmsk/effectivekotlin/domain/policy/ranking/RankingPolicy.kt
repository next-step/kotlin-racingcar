package org.bmsk.effectivekotlin.domain.policy.ranking

import org.bmsk.effectivekotlin.domain.model.RacingCarRoad
import org.bmsk.effectivekotlin.domain.model.RacingCarWinner

sealed interface RankingPolicy {
    fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner

    interface MultipleWinnersAllowed : RankingPolicy {
        override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.MultipleWinner
    }

    interface SingleWinnerOnly : RankingPolicy {
        override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.SingleWinner
    }
}
