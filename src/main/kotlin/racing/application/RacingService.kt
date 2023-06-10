package racing.application

import racing.domain.Cars
import racing.domain.RacingHistory
import racing.domain.strategy.MovableStrategy

class RacingService(private val movableStrategy: MovableStrategy) {

    fun racing(racingInfo: RacingInfo): List<RacingHistory> {
        val players = Cars(racingInfo.capacity)

        return racingInfo.round.map { currentRound ->
            players.notifyMoving(movableStrategy = movableStrategy)
            RacingHistory(round = currentRound, records = players.associateBy({ it.id }, { it.distance }))
        }
    }
}
