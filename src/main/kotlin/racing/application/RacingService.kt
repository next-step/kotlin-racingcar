package racing.application

import racing.domain.Capacity
import racing.domain.Cars
import racing.domain.Name
import racing.domain.RacingHistory
import racing.domain.RacingResult
import racing.domain.dto.RacingGameRequest
import racing.domain.strategy.Navigator

class RacingService(private val navigator: Navigator) {

    fun racing(request: RacingGameRequest): RacingResult {
        val round = Capacity(request.numberOfRound)
        val cars = Cars(request.carNames)

        val racingHistories = round.availableRange.map { currentRound ->
            cars.notifyMoving(navigator = navigator)
            RacingHistory(round = currentRound, records = cars.associateBy({ it.name }, { it.distance }))
        }

        return RacingResult(
            racingHistories = racingHistories,
            winners = findWinners(racingHistories)
        )
    }

    private fun findWinners(racingHistories: List<RacingHistory>): List<Name> {
        val lastHistory = racingHistories.last().records
        val winnerDistance = lastHistory.maxBy { it.value }.value

        return lastHistory.filter { winnerDistance == it.value }
            .map { it.key }
    }
}
