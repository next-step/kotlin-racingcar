package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner

sealed interface RankingPolicy {
    fun RacingCarRoad.determineWinner(): RacingCarWinner

    interface MultipleWinnersAllowed : RankingPolicy {
        override fun RacingCarRoad.determineWinner(): RacingCarWinner.MultipleWinner
    }

    interface SingleWinnerOnly : RankingPolicy {
        override fun RacingCarRoad.determineWinner(): RacingCarWinner.SingleWinner
    }
}
