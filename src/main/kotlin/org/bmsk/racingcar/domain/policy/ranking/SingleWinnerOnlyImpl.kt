package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner
import org.bmsk.racingcar.domain.policy.tie.RacingCarTiebreakerPolicy

internal class SingleWinnerOnlyImpl(
    private val tiebreaker: RacingCarTiebreakerPolicy = RacingCarTiebreakerPolicy.FirstCarWins,
) : RankingPolicy.SingleWinnerOnly {

    override fun determineWinner(racingCarRoad: RacingCarRoad): RacingCarWinner.SingleWinner {
        val tiedWinners = racingCarRoad.findCarsWentFurthest()

        val winner = tiebreaker.breakTie(tiedWinners)
        return RacingCarWinner.SingleWinner(winner)
    }
}
