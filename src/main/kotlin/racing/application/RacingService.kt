package racing.application

import racing.domain.Cars
import racing.domain.RacingHistory
import racing.domain.strategy.MoveStrategy

class RacingService(private val moveStrategy: MoveStrategy) {

    fun racing(racingInfo: RacingInfo): List<RacingHistory> {
        val players = Cars(racingInfo.capacity)

        return racingInfo.round.map { currentRound ->
            players.notifyMoving(moveStrategy = moveStrategy)
            RacingHistory(round = currentRound, records = players.toMap({ it.getId }, { it.getDistance }))
        }
    }
}
