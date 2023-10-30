package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner

sealed interface RankingPolicy {
    fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner

    interface MultipleWinnersAllowed : RankingPolicy {
        override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.MultipleWinner
    }

    interface SingleWinnerOnly : RankingPolicy {
        override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.SingleWinner
    }
}
