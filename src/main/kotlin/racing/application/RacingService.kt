package racing.application

import racing.domain.Name
import racing.domain.RacingHistory
import racing.domain.RacingResult
import racing.domain.strategy.MovableStrategy

class RacingService(private val movableStrategy: MovableStrategy) {

    fun racing(racingInfo: RacingInfo): RacingResult {

        val racingHistories = racingInfo.round.map { currentRound ->
            racingInfo.cars.notifyMoving(movableStrategy = movableStrategy)
            RacingHistory(round = currentRound, records = racingInfo.cars.associateBy({ it.name }, { it.distance }))
        }

        return RacingResult(
            racingHistories = racingHistories,
            winners = findWinners(racingHistories)
        )
    }

    private fun findWinners(racingHistories: List<RacingHistory>): List<Name> {
        val lastHistory = racingHistories.last().records
        val winnerDistance = lastHistory.maxBy { it.value }.value

        return lastHistory.filter { winnerDistance == it.value }.map { it.key }
    }
}
