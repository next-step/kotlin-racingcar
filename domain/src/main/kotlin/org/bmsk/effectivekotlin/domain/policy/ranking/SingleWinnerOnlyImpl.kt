package org.bmsk.effectivekotlin.domain.policy.ranking

import org.bmsk.effectivekotlin.domain.model.RacingCarRoad
import org.bmsk.effectivekotlin.domain.model.RacingCarWinner
import org.bmsk.effectivekotlin.domain.policy.tie.RacingCarTiebreakerPolicy

internal class SingleWinnerOnlyImpl(
    private val tiebreaker: RacingCarTiebreakerPolicy = RacingCarTiebreakerPolicy.FirstCarWins,
) : RankingPolicy.SingleWinnerOnly {

    override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.SingleWinner {
        val tiedWinners = racingCarRoad.findCarsWentFurthest()

        val winner = tiebreaker.breakTie(tiedWinners)
        return RacingCarWinner.SingleWinner(winner)
    }
}
