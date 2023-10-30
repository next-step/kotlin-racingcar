package org.bmsk.racingcar.domain.policy.ranking

import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.model.RacingCarWinner
import org.bmsk.racingcar.domain.policy.tie.RacingCarTiebreakerPolicy

class SingleWinnerOnlyImpl(
    private val tiebreaker: RacingCarTiebreakerPolicy = RacingCarTiebreakerPolicy.FirstCarWins,
) : RankingPolicy.SingleWinnerOnly {

    override fun RacingCarRoad.determineWinner(): RacingCarWinner.SingleWinner {
        val maxPosition = cars.maxBy { it.position.xPos }.position.xPos
        val tiedWinners = cars.filter { it.position.xPos == maxPosition }

        val winner = tiebreaker.breakTie(tiedWinners)
        return RacingCarWinner.SingleWinner(winner)
    }
}
